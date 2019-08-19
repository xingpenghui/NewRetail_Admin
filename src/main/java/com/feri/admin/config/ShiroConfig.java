package com.feri.admin.config;

import com.feri.admin.shiro.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;

/**
 * @program: NewRetail_Admin
 * @description:
 * @author: Feri
 * @create: 2019-08-16 11:44
 */
@Configuration
public class ShiroConfig {

    //1、创建Shiro管理器对象
    @Bean
    public SecurityManager createSM(ShiroRealm shiroRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }
    //2、配置Shiro工厂对象
    @Bean
    public ShiroFilterFactoryBean createSFFB(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置3个页面 登录页 首页 错误页
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.html");
        //设置拦截的接口 哪些需要放行 哪些需要拦截
        //什么样Map集合 可以保证添加顺序
        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();
        //放行资源
        hashMap.put("/login.html","anon");
        hashMap.put("/admin/user/login.do","anon");
        hashMap.put("/css/**","anon");
        hashMap.put("/assets/**","anon");
        hashMap.put("/font/**","anon");
        hashMap.put("/upload/**","anon");
        hashMap.put("/js/**","anon");
        hashMap.put("/Widget/**","anon");
        hashMap.put("/images/**","anon");
        hashMap.put("/products/**","anon");
        //拦截资源
        hashMap.put("/**","authc");//全部拦截
        //设置拦截规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);
        return shiroFilterFactoryBean;
    }
}