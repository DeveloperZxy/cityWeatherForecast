package com.zxy.practiceproject.model.system.config.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.system.config.pojo.dto.ConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.PageConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.QueryConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigCategoryEntity;

import java.util.List;

public interface ConfigCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ConfigCategoryDTO configDTO);

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
    void edit(ConfigCategoryDTO configDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    List<ConfigCategoryEntity> listQuery(QueryConfigCategoryDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageConfigCategoryDTO> pageQuery(PageQuery<QueryConfigCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ConfigCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryConfigCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
