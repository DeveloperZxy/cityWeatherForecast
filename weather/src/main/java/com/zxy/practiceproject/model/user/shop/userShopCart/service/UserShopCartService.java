package com.zxy.practiceproject.model.user.shop.userShopCart.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.ChangeCartNumDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.PageUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.UserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.QueryUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;

import java.util.List;

public interface UserShopCartService extends IService<UserShopCartEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserShopCartDTO userShopCartDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void deleteOneById(String cartId,String userId);


    /**
     * 编辑
     * @param userShopCartDTO
     * @return
     */
    void edit(UserShopCartDTO userShopCartDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<UserShopCartEntity> listQuery(QueryUserShopCartDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserShopCartDTO> pageQuery(PageQuery<QueryUserShopCartDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserShopCartDTO show(String id);

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
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserShopCartDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);

    /**
     * 用户购物车列表
     *
     * @param
     * @return
     */

    List<UserShopCartEntity> getUserCartsList(String userId);

    /**
     * 用户购物车修改数量
     *
     * @param
     * @return
     */
    void updateCartNum(ChangeCartNumDTO changeCartNumDTO);

    void deleteAllById(String id);
}
