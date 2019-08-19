package com.feri.admin;

import com.feri.admin.util.ShiroPassUtil;
import org.junit.Test;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 14:36
 */
public class Pass_Test {
    @Test
    public void test(){
        System.out.println("密码："+ ShiroPassUtil.md5Pass("admin"));
    }
}
