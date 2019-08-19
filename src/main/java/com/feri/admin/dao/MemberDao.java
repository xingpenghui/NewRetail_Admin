package com.feri.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feri.admin.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-08-16
 */
public interface MemberDao extends BaseMapper<Member> {
    Member selectByName(String name);
}
