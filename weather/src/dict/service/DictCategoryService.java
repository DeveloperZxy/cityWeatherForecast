package com.zxy.dict.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.dict.pojo.dto.DictCategoryDTO;
import com.zxy.dict.pojo.dto.PageDictCategoryDTO;
import com.zxy.dict.pojo.dto.QueryDictCategoryDTO;
import com.zxy.dict.pojo.entity.DictCategoryEntity;

import java.util.List;

public interface DictCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(DictCategoryDTO dictDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param dictDTO
     * @return
     */
    void edit(DictCategoryDTO dictDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<DictEntity>为查询结果列表
     */
    List<DictCategoryEntity> listQuery(QueryDictCategoryDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageDictCategoryDTO> pageQuery(PageQuery<QueryDictCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    DictCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryDictCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
