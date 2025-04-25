package com.zxy.practiceproject.model.system.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.system.role.pojo.dto.PageRoleInfoDTO;
import com.zxy.practiceproject.model.system.role.pojo.dto.QueryRoleInfoDTO;
import com.zxy.practiceproject.model.system.role.pojo.entity.RoleInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleInfoMapper extends BaseMapper<RoleInfoEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageRoleInfoDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryRoleInfoDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<RoleInfoEntity> listQuery(QueryRoleInfoDTO queryConfigDTO);
}
