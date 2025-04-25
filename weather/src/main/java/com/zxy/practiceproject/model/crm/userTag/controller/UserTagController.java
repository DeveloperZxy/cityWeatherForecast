package com.zxy.practiceproject.model.crm.userTag.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.UserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagEntity;
import com.zxy.practiceproject.model.crm.userTag.service.UserTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/crm/userTag")
@Slf4j
public class UserTagController {

    @Autowired
    private UserTagService userTagService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserTagDTO userTagDTO) {
        userTagService.add(userTagDTO);
        return Result.success();
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        userTagService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param userTagDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserTagDTO userTagDTO) {
        userTagService.edit(userTagDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserTagDTO> edit(@RequestBody IdDTO idDTO) {
        UserTagDTO userTagDTO =  userTagService.show(idDTO.getId());
        return Result.success(userTagDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserTagEntity>> listQuery(@RequestBody QueryUserTagDTO queryDemoDTO) {
        List<UserTagEntity> result = userTagService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserTagDTO>> pageQuery(@RequestBody PageQuery<QueryUserTagDTO> dto) {
        PageResult<PageUserTagDTO> result = userTagService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 设置状态
     *
     * @param dto 包含ID和状态信息的DTO对象
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/status"})
    public Result setStatus(@RequestBody IdStatusDTO dto) {
        userTagService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形列表
     *
     * @return
     */
    @PostMapping(value = "/tree")
    public Result<List<Tree<String>>> tree() {
        List<Tree<String>> tree = userTagService.getTree();
        return Result.success(tree);
    }
}
