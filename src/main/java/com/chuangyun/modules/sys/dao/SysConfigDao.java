package com.chuangyun.modules.sys.dao;

import com.chuangyun.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置信息
 *
 * @author Jerry Yu
 * @date 2017年11月1日 上午9:31:36
 */
@Mapper
public interface SysConfigDao extends BaseDao<SysConfigEntity> {

    /**
     * 根据key，查询value
     * @param paramKey
     * @return
     */
    SysConfigEntity queryByKey(String paramKey);

    /**
     * 根据key，更新value
     * @param key
     * @param value
     * @return
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);

}
