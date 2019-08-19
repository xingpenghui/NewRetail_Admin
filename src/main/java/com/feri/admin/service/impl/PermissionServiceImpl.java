package com.feri.admin.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.feri.admin.dao.PermissionDao;
import com.feri.admin.dto.Menu;
import com.feri.admin.entity.Member;
import com.feri.admin.entity.Permission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.admin.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {

    @Override
    public List<String> queryUidPrms(int uid) {
        return getBaseMapper().selectPerms(uid);
    }

    @Override
    public R checkPerms(String permission) {
        if(SecurityUtils.getSubject().isPermitted(permission)){
            return R.ok("拥有权限");
        }else {
            return R.failed("暂无权限");
        }
    }

    @Override
    public R queryMenu() {
        //1、获取登录用户
        Member member= (Member) SecurityUtils.getSubject().getSession().getAttribute("user");
        //2、获取所有菜单
        List<Permission> list=getBaseMapper().selectMenu(member.getId());
        //3、获取一级菜单菜单
        //4、获取一级对应的二级菜单
        List<Menu> menus=new ArrayList<>();
        for(Permission p:list){
            if(p.getLevel()==1){
                //一级菜单
                menus.add(new Menu(p,new ArrayList<>()));
            }else {
                //二级菜单
                //将当前二级菜单添加到一级菜单的集合中
                int index=getPid(menus,p.getParentid());
                if(index!=-1){
                    menus.get(index).getChilds().add(p);
                }
            }
        }
        return R.ok(menus);
    }
    //根据权限的id，找到权限对象
    private int getPid( List<Menu> menus,int  pid){
        for(int i=0;i<menus.size();i++){
            if(menus.get(i).getPermission().getId()==pid){
                return i;
            }
        }
        return -1;
    }
}
