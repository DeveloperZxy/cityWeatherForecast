package com.zxy.practiceproject.login.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.Result;
import com.zxy.common.utils.JwtUtil;
import com.zxy.practiceproject.login.pojo.dto.UserLoginDTO;
import com.zxy.practiceproject.login.pojo.dto.UserLoginVO;
import com.zxy.practiceproject.login.service.UsersService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *  登录
 * admin/staff
 * user/customer 客户
 * crm:客户管理系统
 * cms:内容管理系统
 * system:系统管理
 * info:基础模块
 * <p>
 * info_org_info  组织（集团/区域/公司/部门）
 * info_org_area
 * info_org_company
 * info_org_dept
 * <p>
 * <p>
 * <p>
 * info_admin_info
 */
@RestController
@RequestMapping("/admin/users")
@Slf4j
public class UsersController {

    @Autowired
    private UsersService userService;


    /**
     * 登录
     *
     * @param
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        //登录操作
        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return Result.success(userLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        //清除登录用户id的线程
        JwtUtil.clearLoginUserId();
        //退出系统操作
        return Result.success();
    }

    /**
     * 根据用户id获取权限
     * @param
     * @return
     */
    @PostMapping("/getPermissions")
    public Result<List<Tree<String>>> getPermissions() {
        //解析token中的id
       String id= JwtUtil.getLoginUserId();
        log.info("id:{}",id);
        List<Tree<String>> tree = userService.getPermissions(id);
       return Result.success(tree);
    }
}