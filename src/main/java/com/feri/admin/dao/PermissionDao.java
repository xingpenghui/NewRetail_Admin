package com.feri.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feri.admin.entity.Permission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
public interface PermissionDao extends BaseMapper<Permission> {

    List<String> selectPerms(int uid);
    List<Permission> selectMenu(int uid);

}
