package com.zxy.practiceproject.model.user.shop.userShopOrder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.PageUserShopOrderDetailsDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.QueryUserShopOrderDetailsDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderDetailsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserShopOrderDetailsMapper extends BaseMapper<UserShopOrderDetailsEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserShopOrderDetailsDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserShopOrderDetailsDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<UserShopOrderDetailsEntity> listQuery(QueryUserShopOrderDetailsDTO queryConfigDTO);
}
