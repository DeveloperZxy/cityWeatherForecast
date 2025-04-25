package com.zxy.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.dict.pojo.dto.PageDictDTO;
import com.zxy.dict.pojo.dto.QueryDictDTO;
import com.zxy.dict.pojo.entity.DictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictMapper extends BaseMapper<DictEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageDictDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryDictDTO filters);


}
