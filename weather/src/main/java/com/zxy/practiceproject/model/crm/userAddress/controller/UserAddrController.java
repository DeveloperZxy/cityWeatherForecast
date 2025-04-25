package com.zxy.practiceproject.model.crm.userAddress.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.OrderDetailsVO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.PageUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.UserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.QueryUserAddrDTO;
import com.zxy.practiceproject.model.crm.userAddress.pojo.entity.UserAddrEntity;
import com.zxy.practiceproject.model.crm.userAddress.service.UserAddrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/crm/userAddress")
@Slf4j
public class UserAddrController {

    @Autowired
    private UserAddrService userAddrService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserAddrDTO userAddrDTO) {
        userAddrService.add(userAddrDTO);
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
        userAddrService.del(idDTO);
        return Result.success();
    }



    /**
     * 编辑
     *
     * @param userAddrDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserAddrDTO userAddrDTO) {
        userAddrService.edit(userAddrDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserAddrDTO> edit(@RequestBody IdDTO idDTO) {
        UserAddrDTO userAddrDTO =  userAddrService.show(idDTO.getId());
        return Result.success(userAddrDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserAddrEntity>> listQuery(@RequestBody QueryUserAddrDTO queryDemoDTO) {
        List<UserAddrEntity> result = userAddrService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserAddrDTO>> pageQuery(@RequestBody PageQuery<QueryUserAddrDTO> dto) {
        PageResult<PageUserAddrDTO> result = userAddrService.pageQuery(dto);
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
        userAddrService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserAddrDTO> dto) {
        List<Tree<String>> result = userAddrService.treeQuery(dto);
        return Result.success(result);
    }

}
