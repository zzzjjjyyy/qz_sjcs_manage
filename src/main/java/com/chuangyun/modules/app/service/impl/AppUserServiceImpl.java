package com.chuangyun.modules.app.service.impl;


import com.chuangyun.modules.app.dao.AppUserDao;
import com.chuangyun.modules.app.entity.AppUserEntity;
import com.chuangyun.modules.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * app用戶实现类
 *
 * @author Jerry Yu
 * @date 2017年11月1日 上午9:31:36
 */
@Service("appUserService")
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserDao sysUserDao;

    @Override
    public AppUserEntity queryObject(Long userId) {
        return sysUserDao.queryObject(userId);
    }

    @Override
    public AppUserEntity queryByMobile(String mobile) {
        return sysUserDao.queryByMobile(mobile);
    }
}
