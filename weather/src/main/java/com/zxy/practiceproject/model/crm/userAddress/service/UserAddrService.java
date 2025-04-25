package com.zxy.practiceproject.model.crm.userAddress.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.OrderDetailsVO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.PageUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.UserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.QueryUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.entity.UserAddrEntity;

import java.util.List;

public interface UserAddrService extends IService<UserAddrEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserAddrDTO productTagDTO);

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
    void edit(UserAddrDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<UserAddrEntity> listQuery(QueryUserAddrDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserAddrDTO> pageQuery(PageQuery<QueryUserAddrDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserAddrDTO show(String id);

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
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserAddrDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    OrderDetailsVO getOrderDetails(UserAddrDTO userAddrDTO);
}
