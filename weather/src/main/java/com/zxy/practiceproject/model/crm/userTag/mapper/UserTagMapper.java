package com.zxy.practiceproject.model.crm.userTag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserTagMapper extends BaseMapper<UserTagEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserTagDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserTagDTO filters);


}
