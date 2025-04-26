package com.zxy.practiceproject.model.weather.cityCare.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.OrderDetailsVO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.CityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.PageCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.QueryCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.CityCareInfoEntity;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.DetailsCityCareEntity;

import java.util.List;

public interface CityCareInfoService extends IService<CityCareInfoEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(CityCareInfoDTO productTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param productTagDTO
     * @return
     */
    void edit(CityCareInfoDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<CityCareInfoEntity> listQuery(QueryCityCareInfoDTO queryConfigDTO);
    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<DetailsCityCareEntity> listQuery2(QueryCityCareInfoDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageCityCareInfoDTO> pageQuery(PageQuery<QueryCityCareInfoDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    CityCareInfoDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);


    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryCityCareInfoDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    OrderDetailsVO getOrderDetails(CityCareInfoDTO cityInfoDTO);


}
