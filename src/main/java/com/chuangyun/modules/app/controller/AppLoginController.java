package com.chuangyun.modules.app.controller;

import com.chuangyun.common.utils.R;
import com.chuangyun.common.validator.AbstractAssert;
import com.chuangyun.modules.app.entity.AppUserEntity;
import com.chuangyun.modules.app.service.AppUserService;
import com.chuangyun.modules.app.utils.JwtUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author Jerry Yu
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/app")
public class AppLoginController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("/login")
    public R login(String mobile, String password) {
        AbstractAssert.isBlank(mobile, "手机号不能为空");
        AbstractAssert.isBlank(password, "密码不能为空");

        //用户信息
        AppUserEntity user = appUserService.queryByMobile(mobile);

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }

        //生成token
        String token = jwtUtils.generateToken(user.getUserId());

        Map<String, Object> map = new HashMap<>(3);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("user", user);

        return R.ok(map);
    }

}
