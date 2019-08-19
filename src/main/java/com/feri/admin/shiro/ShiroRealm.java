package com.feri.admin.shiro;

import com.feri.admin.entity.Member;
import com.feri.admin.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @program: NewRetail_Admin
 * @description: 基于Shiro 实现自定义Realm
 * @author: Feri
 * @create: 2019-08-16 11:29
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private PermissionService permissionService;

    //授权 查询用户的权限并设置
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、获取登录信息
        Member member= (Member) SecurityUtils.getSubject().getSession().getAttribute("user");
        //2、验证用户信息
        if(member!=null){
            //3、查询当前用户的所有的权限 只要权限名称
            List<String> prms=permissionService.queryUidPrms(member.getId());
            //4、设置权限到Shiro中
            SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
            authorizationInfo.addStringPermissions(prms);
            return authorizationInfo;
        }
        return null;
    }
    //认证 校验用户是否登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1、获取传递的令牌
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //2、校验令牌的内容
        if(token!=null && token.getUsername()!=null){
            //3、生成认证信息
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
