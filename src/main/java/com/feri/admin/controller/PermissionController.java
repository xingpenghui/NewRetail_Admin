package com.feri.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.feri.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 14:07
 */
@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    //查询用户是否拥有权限
    @GetMapping("/admin/permission/checkperm.do")
    public R checkPerm(String p){
       return permissionService.checkPerms(p);
    }
    @CrossOrigin
    @GetMapping("/admin/menu/getallmenu.do")
    public R queryAll(){
        return permissionService.queryMenu();
    }
}
