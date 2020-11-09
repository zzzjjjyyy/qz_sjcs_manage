package com.chuangyun.modules.app.dao;

import com.chuangyun.modules.app.entity.AppUserEntity;
import com.chuangyun.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author Jerry Yu
 * @date 2017-11-2 15:22:06
 */
@Mapper
public interface AppUserDao extends BaseDao<AppUserEntity> {

    /**
     * 用户App登录
     * @param mobile
     * @return
     */
    AppUserEntity queryByMobile(String mobile);
}
