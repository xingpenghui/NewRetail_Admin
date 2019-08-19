package com.feri.admin.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.admin.dao.MemberDao;
import com.feri.admin.entity.Member;
import com.feri.admin.service.MemberService;
import com.feri.admin.util.ShiroPassUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {

    @Override
    public R login(String name, String pass) {
        //1、校验账号是否存在
        Member member=getBaseMapper().selectByName(name);
        if(member!=null){
            //2、校验密码是否正确
            if(Objects.equals(member.getPassword(), ShiroPassUtil.md5Pass(pass))){
                //3、Shiro相关操作
                //3、创建主题
                Subject subject= SecurityUtils.getSubject();
                //4、创建令牌
                UsernamePasswordToken token=new UsernamePasswordToken(name,pass);
                //5、发起登录
                subject.login(token);
                subject.getSession().setAttribute("user",member);
                return R.ok("成功");
            }
        }
        return R.failed("用户名或密码不正确");
    }

    @Override
    public R loginout() {
        Subject subject=SecurityUtils.getSubject();
        subject.getSession().removeAttribute("user");
        subject.logout();
        return R.ok("注销成功");
    }
}
