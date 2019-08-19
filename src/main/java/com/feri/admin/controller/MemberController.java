package com.feri.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.feri.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 14:05
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/admin/user/login.do")
    public R login(String name, String pass)
    {
        return memberService.login(name, pass);
    }
    //注销
    @GetMapping("/admin/user/loginout.do")
    public R loginout(){
        return memberService.loginout();
    }
}
