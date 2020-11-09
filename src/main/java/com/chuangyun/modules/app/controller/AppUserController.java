package com.chuangyun.modules.app.controller;


import com.chuangyun.common.utils.R;
import com.chuangyun.common.utils.ShiroUtils;
import com.chuangyun.modules.app.annotation.Login;
import com.chuangyun.modules.app.annotation.LoginUser;
import com.chuangyun.modules.app.entity.AppUserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP测试接口
 *
 * @author Jerry Yu
 * @date 2017-11-2 15:47
 */
@RestController
@RequestMapping("/app/user")
public class AppUserController {

    /**
     * 获取用户信息
     */
    @Login
    @GetMapping("userInfo")
    public R userInfo(@LoginUser AppUserEntity user) {
        return R.ok().put("user", user);
    }

    /**
     * 获取用户ID
     */
    @Login
    @GetMapping("userId")
    public R userInfo(@RequestAttribute("userId") Integer userId) {
        return R.ok().put("userId", ShiroUtils.getSubject().getPrincipal());
    }
}
