package com.zxy.practiceproject.model.info.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper extends BaseMapper<AdminEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageAdminDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryAdminDTO filters);


}
