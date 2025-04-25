package com.zxy.practiceproject.model.system.config.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.config.pojo.dto.PageConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.QueryConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigCategoryMapper extends BaseMapper<ConfigCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageConfigCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryConfigCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<ConfigCategoryEntity> listQuery(@Param("filters") QueryConfigCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
