package com.zxy.practiceproject.model.system.sms.tpl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TplCategoryMapper extends BaseMapper<TplCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageTplCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryTplCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<TplCategoryEntity> listQuery(@Param("filters") QueryTplCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
