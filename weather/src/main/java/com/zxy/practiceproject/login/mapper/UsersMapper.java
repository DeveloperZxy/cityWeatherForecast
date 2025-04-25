package com.zxy.practiceproject.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxy.practiceproject.login.pojo.entity.User;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper extends BaseMapper<UserEntity> {
    /**
     * 根据用户名查询用户信息
     *
     * @param
     * @return
     */
    @Select("select * from crm_user_info where username=#{username}")
    UserEntity  getByUsername(String username);

}
