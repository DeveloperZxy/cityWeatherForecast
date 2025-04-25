package com.zxy.practiceproject.model.crm.userAddress.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.PageUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.QueryUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.entity.UserAddrEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddrMapper extends BaseMapper<UserAddrEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserAddrDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserAddrDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<UserAddrEntity> listQuery(QueryUserAddrDTO queryConfigDTO);
}
