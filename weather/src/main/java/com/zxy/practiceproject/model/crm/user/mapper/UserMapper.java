package com.zxy.practiceproject.model.crm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserDTO filters);


}
