package com.zxy.practiceproject.model.weather.cityCare.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.weather.city.CityWeatherAPIController;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.CityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.CityCareQueryDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.PageCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.QueryCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.CityCareInfoEntity;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.DetailsCityCareEntity;
import com.zxy.practiceproject.model.weather.cityCare.service.CityCareInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/weather/cityCareInfo")
@Slf4j
public class CityCareInfoController {

    @Autowired
    private CityCareInfoService cityInfoService;


    /**
     * 新增
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CityCareInfoDTO cityInfoDTO) {
        cityInfoService.add(cityInfoDTO);
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
        cityInfoService.del(idDTO);
        return Result.success();
    }


    /**
     * 编辑
     *
     * @param cityInfoDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody CityCareInfoDTO cityInfoDTO) {
        cityInfoService.edit(cityInfoDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<CityCareInfoDTO> edit(@RequestBody IdDTO idDTO) {
        CityCareInfoDTO cityInfoDTO = cityInfoService.show(idDTO.getId());
        return Result.success(cityInfoDTO);
    }

//    /**
//     * 列表查询
//     *
//     * @param
//     */
//    @PostMapping("/list")
//    public Result<List<CityCareInfoEntity>> listQuery(@RequestBody QueryCityCareInfoDTO queryDemoDTO) {
//        List<CityCareInfoEntity> result = cityInfoService.listQuery(queryDemoDTO);
//        return Result.success(result);
//    }
    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<DetailsCityCareEntity>> listQuery2(@RequestBody QueryCityCareInfoDTO queryDemoDTO) {
        List<DetailsCityCareEntity> result = cityInfoService.listQuery2(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageCityCareInfoDTO>> pageQuery(@RequestBody PageQuery<QueryCityCareInfoDTO> dto) {
        PageResult<PageCityCareInfoDTO> result = cityInfoService.pageQuery(dto);
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
        cityInfoService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree < String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryCityCareInfoDTO> dto) {
        List<Tree<String>> result = cityInfoService.treeQuery(dto);
        return Result.success(result);
    }


}
