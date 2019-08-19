package com.feri.admin.dto;

import com.feri.admin.entity.Permission;
import lombok.Data;

import java.util.List;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-19 10:00
 */
@Data
public class Menu {
    private Permission permission;
    private List<Permission> childs;
    public Menu() {
    }
    public Menu(Permission permission, List<Permission> childs) {
        this.permission = permission;
        this.childs = childs;
    }
}
