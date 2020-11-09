package com.chuangyun.modules.sys.controller;

import com.chuangyun.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 *
 * @author Jerry YU
 * @date 2017年11月9日 下午9:42:26
 */
public abstract class AbstractController {
    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
