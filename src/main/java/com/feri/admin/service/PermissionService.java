package com.feri.admin.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.feri.admin.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
public interface PermissionService extends IService<Permission> {
    List<String> queryUidPrms(int uid);
    R checkPerms(String permission);
    R queryMenu();
}
