package com.zxy.practiceproject.model.system.permission.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.system.permission.pojo.dto.PagePermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.dto.PermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.dto.QueryPermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.entity.PermissionInfoEntity;
import com.zxy.practiceproject.model.system.permission.service.PermissionInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/permission/permissionInfo")
@Slf4j
public class PermissionInfoController {

    @Autowired
    private PermissionInfoService permissionInfoService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody PermissionInfoDTO permissionInfoDTO) {
        permissionInfoService.add(permissionInfoDTO);
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
        permissionInfoService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param permissionInfoDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody PermissionInfoDTO permissionInfoDTO) {
        permissionInfoService.edit(permissionInfoDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<PermissionInfoDTO> edit(@RequestBody IdDTO idDTO) {
        PermissionInfoDTO permissionInfoDTO =  permissionInfoService.show(idDTO.getId());
        return Result.success(permissionInfoDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<PermissionInfoEntity>> listQuery(@RequestBody QueryPermissionInfoDTO queryDemoDTO) {
        List<PermissionInfoEntity> result = permissionInfoService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PagePermissionInfoDTO>> pageQuery(@RequestBody PageQuery<QueryPermissionInfoDTO> dto) {
        PageResult<PagePermissionInfoDTO> result = permissionInfoService.pageQuery(dto);
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
        permissionInfoService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryPermissionInfoDTO> dto) {
        List<Tree<String>> result = permissionInfoService.treeQuery(dto);
        return Result.success(result);
    }

}
