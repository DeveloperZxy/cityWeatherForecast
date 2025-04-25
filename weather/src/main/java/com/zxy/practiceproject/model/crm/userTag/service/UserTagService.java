package com.zxy.practiceproject.model.crm.userTag.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.UserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagEntity;

import java.util.List;

public interface UserTagService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserTagDTO userTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param userTagDTO
     * @return
     */
    void edit(UserTagDTO userTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<UserTagEntity> listQuery(QueryUserTagDTO queryUserTagDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserTagDTO> pageQuery(PageQuery<QueryUserTagDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserTagDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);

    List<Tree<String>> getTree();
}
