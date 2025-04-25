package com.zxy.practiceproject.model.crm.userTag.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.UserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagCategoryEntity;

import java.util.List;

public interface UserTagCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserTagCategoryDTO userTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param userTagDTO
     * @return
     */
    void edit(UserTagCategoryDTO userTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<UserTagEntity>为查询结果列表
     */
    List<UserTagCategoryEntity> listQuery(QueryUserTagCategoryDTO queryUserTagDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserTagCategoryDTO> pageQuery(PageQuery<QueryUserTagCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserTagCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserTagCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
