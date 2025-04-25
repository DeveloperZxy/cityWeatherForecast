package com.zxy.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.dict.pojo.dto.PageDictCategoryDTO;
import com.zxy.dict.pojo.dto.QueryDictCategoryDTO;
import com.zxy.dict.pojo.entity.DictCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictCategoryMapper extends BaseMapper<DictCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageDictCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryDictCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<DictCategoryEntity> listQuery(@Param("filters") QueryDictCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
