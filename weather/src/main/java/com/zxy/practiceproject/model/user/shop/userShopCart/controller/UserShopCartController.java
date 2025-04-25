package com.zxy.practiceproject.model.user.shop.userShopCart.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.common.utils.JwtUtil;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.ChangeCartNumDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.PageUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.UserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto.QueryUserShopCartDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import com.zxy.practiceproject.model.user.shop.userShopCart.service.UserShopCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/shop/userShopCartInfo")
@Slf4j
public class UserShopCartController {

    @Autowired
    private UserShopCartService userShopCartService;

    /**
     * 新增购物车条条数据
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserShopCartDTO userShopCartDTO) {
        userShopCartService.add(userShopCartDTO);
        return Result.success();
    }



    /**
     * 用户购物车列表
     *
     * @param
     * @return
     */
    @PostMapping("/getUserCartsList")
    public Result<List<UserShopCartEntity>> getUserCartsList() {
        String userId= JwtUtil.getLoginUserId();
        List<UserShopCartEntity> result = userShopCartService.getUserCartsList(userId);
        return Result.success(result);
    }

    /**
     * 用户购物车修改数量
     *
     * @param
     * @return
     */
    @PostMapping("/updateCartNum")
    public Result updateCartNum(@RequestBody ChangeCartNumDTO changeCartNumDTO) {
        userShopCartService.updateCartNum(changeCartNumDTO);
        return Result.success();
    }
  /**
     * 用户购物车删除接口
     *
     * @param
     * @return
     */
    @PostMapping("/delOne")
    public Result deleteOneById(@RequestBody IdDTO cartIdDto) {
        userShopCartService.deleteOneById(cartIdDto.getId(),JwtUtil.getLoginUserId());
        return Result.success();
    }

    /**
     * 删除某用户全部购物车
     *
     * @param
     * @return
     */
    @PostMapping("/delAll")
    public Result deleteAllById(@RequestBody IdDTO userIdDTO) {
        userShopCartService.deleteAllById(userIdDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param userShopCartDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserShopCartDTO userShopCartDTO) {
        userShopCartService.edit(userShopCartDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserShopCartDTO> edit(@RequestBody IdDTO idDTO) {
        UserShopCartDTO userShopCartDTO =  userShopCartService.show(idDTO.getId());
        return Result.success(userShopCartDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserShopCartEntity>> listQuery(@RequestBody QueryUserShopCartDTO queryDemoDTO) {
        List<UserShopCartEntity> result = userShopCartService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserShopCartDTO>> pageQuery(@RequestBody PageQuery<QueryUserShopCartDTO> dto) {
        PageResult<PageUserShopCartDTO> result = userShopCartService.pageQuery(dto);
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
        userShopCartService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserShopCartDTO> dto) {
        List<Tree<String>> result = userShopCartService.treeQuery(dto);
        return Result.success(result);
    }

}
