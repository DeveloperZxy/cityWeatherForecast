package com.zxy.practiceproject.model.crm.user.controller;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.crm.user.pojo.dto.ChangePasswordDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.UserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import com.zxy.practiceproject.model.crm.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/crm/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserDTO configDTO) {
        userService.add(configDTO);
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
        userService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param configDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserDTO configDTO) {
        userService.edit(configDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserDTO> edit(@RequestBody IdDTO idDTO) {
        UserDTO configDTO =  userService.show(idDTO.getId());
        return Result.success(configDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserEntity>> listQuery(@RequestBody QueryUserDTO queryDemoDTO) {
        List<UserEntity> result = userService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserDTO>> pageQuery(@RequestBody PageQuery<QueryUserDTO> dto) {
        PageResult<PageUserDTO> result = userService.pageQuery(dto);
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
        userService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }
    /**
     * 设置密码
     *
     * @param dto 包含ID和状态信息的DTO对象
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/changePassword"})
    public Result changePassword(@RequestBody ChangePasswordDTO dto) {
        userService.changePassword(dto);
        return Result.success();
    }
}
