package com.zxy.practiceproject.model.info.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminCategoryMapper extends BaseMapper<AdminCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageAdminCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryAdminCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<AdminCategoryEntity> listQuery(@Param("filters") QueryAdminCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
