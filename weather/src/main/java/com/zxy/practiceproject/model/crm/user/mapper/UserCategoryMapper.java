package com.zxy.practiceproject.model.crm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCategoryMapper extends BaseMapper<UserCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<UserCategoryEntity> listQuery(@Param("filters") QueryUserCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
