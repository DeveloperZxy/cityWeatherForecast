package com.zxy.practiceproject.model.user.shop.userShopOrder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.PageUserShopOrderDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.QueryUserShopOrderDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserShopOrderMapper extends BaseMapper<UserShopOrderEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserShopOrderDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserShopOrderDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<UserShopOrderEntity> listQuery(QueryUserShopOrderDTO queryConfigDTO);
}
