package com.zxy.practiceproject.model.system.config.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.config.pojo.dto.PageConfigDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.QueryConfigDTO;
import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConfigMapper extends BaseMapper<ConfigEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageConfigDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryConfigDTO filters);


}
