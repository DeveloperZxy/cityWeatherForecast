package com.zxy.dict.controller;

import com.zxy.common.pojo.IdDTO;
import com.zxy.common.pojo.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.dict.pojo.dto.DictDTO;
import com.zxy.dict.pojo.dto.PageDictDTO;
import com.zxy.dict.pojo.dto.QueryDictDTO;
import com.zxy.dict.pojo.entity.DictEntity;
import com.zxy.dict.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/dict")
@Slf4j
public class DictController {

    @Autowired
    private DictService configService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody DictDTO configDTO) {
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
    public Result edit(@RequestBody DictDTO configDTO) {
        configService.edit(configDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<DictDTO> edit(@RequestBody IdDTO idDTO) {
        DictDTO configDTO =  configService.show(idDTO.getId());
        return Result.success(configDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<DictEntity>> listQuery(@RequestBody QueryDictDTO queryDemoDTO) {
        List<DictEntity> result = configService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageDictDTO>> pageQuery(@RequestBody PageQuery<QueryDictDTO> dto) {
        PageResult<PageDictDTO> result = configService.pageQuery(dto);
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
}
