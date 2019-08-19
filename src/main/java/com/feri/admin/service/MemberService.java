package com.feri.admin.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.admin.entity.Member;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
public interface MemberService extends IService<Member> {
    R login(String name,String pass);
    R loginout();


}
