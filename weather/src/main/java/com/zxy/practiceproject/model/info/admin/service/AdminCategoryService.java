package com.zxy.practiceproject.model.info.admin.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminCategoryEntity;

import java.util.List;

public interface AdminCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(AdminCategoryDTO configDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param configDTO
     * @return
     */
    void edit(AdminCategoryDTO configDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    List<AdminCategoryEntity> listQuery(QueryAdminCategoryDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageAdminCategoryDTO> pageQuery(PageQuery<QueryAdminCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    AdminCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryAdminCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
