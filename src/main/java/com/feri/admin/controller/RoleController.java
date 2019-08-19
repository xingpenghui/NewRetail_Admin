package com.feri.admin.controller;

import com.feri.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 14:07
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

}
