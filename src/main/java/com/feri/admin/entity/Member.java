package com.feri.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("sys_member")
public class Member extends Model<Member> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String mname;//用户名
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;
    private Integer flag;//1有效 2临时无效 3永久无效
}