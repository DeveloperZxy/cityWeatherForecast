package com.zxy.practiceproject.model.user.shop.userShopCart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.PageUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.QueryUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserShopCartMapper extends BaseMapper<UserShopCartEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageUserShopCartDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryUserShopCartDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<UserShopCartEntity> listQuery(QueryUserShopCartDTO queryConfigDTO);
}
