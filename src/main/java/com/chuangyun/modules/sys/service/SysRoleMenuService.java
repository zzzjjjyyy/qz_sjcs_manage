package com.chuangyun.modules.sys.service;

import java.util.List;


/**
 * 角色与菜单对应关系
 *
 * @author Jerry Yu
 * @date 2017年11月1日 上午9:31:36
 */
public interface SysRoleMenuService {

    /**
     * 新增或更新角色与菜单权限关系
     * @param roleId
     * @param menuIdList
     */
    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     *
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdList(Long roleId);

}
