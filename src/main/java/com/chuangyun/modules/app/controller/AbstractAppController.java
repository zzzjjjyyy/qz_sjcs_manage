package com.chuangyun.modules.app.controller;

import com.chuangyun.common.utils.Constant;
import com.chuangyun.modules.app.entity.AppUserEntity;
import com.chuangyun.modules.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jerry Yu
 * @date 2017/11/7 22:12
 */
public class AbstractAppController {
    @Autowired
    private AppUserService appUserService;

    /**
     * 获取登录用户信息
     *
     * @param request
     * @return
     */
    protected AppUserEntity getUser(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getAttribute(Constant.USER_KEY).toString());
        return appUserService.queryObject(userId);
    }

    /**
     * 获取登录用户的ID
     *
     * @param request
     * @return
     */
    protected Long getUserId(HttpServletRequest request) {
        return Long.valueOf(request.getAttribute(Constant.USER_KEY).toString());
    }
}
