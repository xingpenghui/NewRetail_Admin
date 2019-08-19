package com.feri.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 14:06
 */
@Controller
public class IndexController {
    //
    @GetMapping("/admin/{name}")
    public String index(@PathVariable String name){
        System.out.println(name);
        return "/"+name;
    }

}
