package com.zxy.practiceproject.model.system.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.permission.pojo.dto.PagePermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.dto.QueryPermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.entity.PermissionInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionInfoMapper extends BaseMapper<PermissionInfoEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PagePermissionInfoDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryPermissionInfoDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<PermissionInfoEntity> listQuery(QueryPermissionInfoDTO queryConfigDTO);
}
