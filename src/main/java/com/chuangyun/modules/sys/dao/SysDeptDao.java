package com.chuangyun.modules.sys.dao;

import com.chuangyun.modules.sys.entity.SysDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jerry Yu
 * @date 2017年11月1日 上午9:31:36
 */
@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {
    /**
     * 查询上级部门deptId的部门列表
     *
     * @param deptId
     * @return
     */
    List<SysDeptEntity> queryDeptListParentId(long deptId);
}
