package com.zxy.practiceproject.model.system.sms.tpl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TplMapper extends BaseMapper<TplEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageTplDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryTplDTO filters);


}
