package com.zxy.practiceproject.model.crm.user.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.UserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserCategoryEntity;

import java.util.List;

public interface UserCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserCategoryDTO userDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param userDTO
     * @return
     */
    void edit(UserCategoryDTO userDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<DictEntity>为查询结果列表
     */
    List<UserCategoryEntity> listQuery(QueryUserCategoryDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserCategoryDTO> pageQuery(PageQuery<QueryUserCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
