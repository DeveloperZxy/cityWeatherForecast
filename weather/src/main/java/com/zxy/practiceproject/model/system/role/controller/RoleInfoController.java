package com.zxy.practiceproject.model.system.role.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.system.role.pojo.dto.PageRoleInfoDTO;
import com.zxy.practiceproject.model.system.role.pojo.dto.RoleInfoDTO;
import com.zxy.practiceproject.model.system.role.pojo.dto.QueryRoleInfoDTO;
import com.zxy.practiceproject.model.system.role.pojo.entity.RoleInfoEntity;
import com.zxy.practiceproject.model.system.role.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/role/roleInfo")
@Slf4j
public class RoleInfoController {

    @Autowired
    private RoleInfoService permissionInfoService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody RoleInfoDTO permissionInfoDTO) {
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
    public Result edit(@RequestBody RoleInfoDTO permissionInfoDTO) {
        permissionInfoService.edit(permissionInfoDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<RoleInfoDTO> edit(@RequestBody IdDTO idDTO) {
        RoleInfoDTO permissionInfoDTO =  permissionInfoService.show(idDTO.getId());
        return Result.success(permissionInfoDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<RoleInfoEntity>> listQuery(@RequestBody QueryRoleInfoDTO queryDemoDTO) {
        List<RoleInfoEntity> result = permissionInfoService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageRoleInfoDTO>> pageQuery(@RequestBody PageQuery<QueryRoleInfoDTO> dto) {
        PageResult<PageRoleInfoDTO> result = permissionInfoService.pageQuery(dto);
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
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryRoleInfoDTO> dto) {
        List<Tree<String>> result = permissionInfoService.treeQuery(dto);
        return Result.success(result);
    }

}
