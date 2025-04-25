package com.zxy.practiceproject.model.system.permission.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.system.permission.pojo.dto.PagePermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.dto.PermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.dto.QueryPermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.entity.PermissionInfoEntity;

import java.util.List;

public interface PermissionInfoService {

    public List<Tree<String>> getTree(String includeRoot);
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(PermissionInfoDTO permissionInfoDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param permissionInfoDTO
     * @return
     */
    void edit(PermissionInfoDTO permissionInfoDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<PermissionInfoEntity> listQuery(QueryPermissionInfoDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PagePermissionInfoDTO> pageQuery(PageQuery<QueryPermissionInfoDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    PermissionInfoDTO show(String id);

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
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryPermissionInfoDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);
}
