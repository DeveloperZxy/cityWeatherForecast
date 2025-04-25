package com.zxy.practiceproject.model.info.admin.controller;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PasswordDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;
import com.zxy.practiceproject.model.info.admin.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService configService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody AdminDTO configDTO) {
        configService.add(configDTO);
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
        configService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param configDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody AdminDTO configDTO) {
        configService.edit(configDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<AdminDTO> edit(@RequestBody IdDTO idDTO) {
        AdminDTO configDTO =  configService.show(idDTO.getId());
        return Result.success(configDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<AdminEntity>> listQuery(@RequestBody QueryAdminDTO queryDemoDTO) {
        List<AdminEntity> result = configService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageAdminDTO>> pageQuery(@RequestBody PageQuery<QueryAdminDTO> dto) {
        PageResult<PageAdminDTO> result = configService.pageQuery(dto);
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
        configService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }
    /**
     * 设置密码
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/resetPassword"})
    public Result setStatus(@RequestBody PasswordDTO dto) {
        configService.resetPassword(dto);
        return Result.success();
    }
}
