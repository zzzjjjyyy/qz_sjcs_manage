package com.chuangyun.modules.app.service;


import com.chuangyun.modules.app.entity.AppUserEntity;

/**
 * 系统用户
 *
 * @author Jerry Yu
 * @date 2017年11月1日 上午9:31:36
 */
public interface AppUserService {
    /**
     * 查询
     * @param userId
     * @return
     */
    AppUserEntity queryObject(Long userId);

    /**
     * 根据手机号查询用户信息
     * @param mobile
     * @return
     */
    AppUserEntity queryByMobile(String mobile);

}
