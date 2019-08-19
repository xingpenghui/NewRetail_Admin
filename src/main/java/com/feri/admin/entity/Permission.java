package com.feri.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
@Data
@TableName("sys_permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String icon;
    private Integer parentid;
    private String prms;
    private Integer type;
    private Integer level;
}