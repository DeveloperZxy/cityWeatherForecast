package com.zxy.practiceproject.model.crm.userTag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTagCategoryMapper extends BaseMapper<UserTagCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserTagCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserTagCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<UserTagCategoryEntity> listQuery(@Param("filters") QueryUserTagCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
