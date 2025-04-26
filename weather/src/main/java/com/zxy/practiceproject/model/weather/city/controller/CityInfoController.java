package com.zxy.practiceproject.model.weather.city.controller;

import cn.hutool.core.lang.tree.Tree;
import com.google.common.collect.ObjectArrays;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.weather.city.CityWeatherAPIController;
import com.zxy.practiceproject.model.weather.city.pojo.dto.CityQueryDTO;
import com.zxy.practiceproject.model.weather.city.pojo.dto.PageCityInfoDTO;
import com.zxy.practiceproject.model.weather.city.pojo.dto.QueryCityInfoDTO;
import com.zxy.practiceproject.model.weather.city.pojo.dto.CityInfoDTO;
import com.zxy.practiceproject.model.weather.city.pojo.entity.CityEntity;
import com.zxy.practiceproject.model.weather.city.pojo.entity.CityInfoEntity;
import com.zxy.practiceproject.model.weather.city.service.CityInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/admin/weather/cityInfo")
@Slf4j
public class CityInfoController {

    @Autowired
    private CityInfoService cityInfoService;


    /**
     * 热门城市
     *
     * @param
     * @return
     */
    @PostMapping("/hotCities")
    public Result<List<CityEntity>> hotCities(@RequestBody CityInfoDTO cityInfoDTO) {
        CityWeatherAPIController cityWeatherAPIController = new CityWeatherAPIController();
        List<CityEntity> hotCities = cityWeatherAPIController.getHotCities();
        return Result.success(hotCities);
    }

    /**
     * 搜索城市
     *
     * @param
     * @return
     */
    @PostMapping("/searchCity")
    public Result<List<CityEntity>> searchCity(@RequestBody CityQueryDTO dto) {
        CityWeatherAPIController cityWeatherAPIController = new CityWeatherAPIController();
        List<CityEntity> hotCities = cityWeatherAPIController.searchCity(dto.getName());
        return Result.success(hotCities);
    }

    /**
     * 新增
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CityInfoDTO cityInfoDTO) {
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
    public Result edit(@RequestBody CityInfoDTO cityInfoDTO) {
        cityInfoService.edit(cityInfoDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<CityInfoDTO> edit(@RequestBody IdDTO idDTO) {
        CityInfoDTO cityInfoDTO = cityInfoService.show(idDTO.getId());
        return Result.success(cityInfoDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<CityInfoEntity>> listQuery(@RequestBody QueryCityInfoDTO queryDemoDTO) {
        List<CityInfoEntity> result = cityInfoService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageCityInfoDTO>> pageQuery(@RequestBody PageQuery<QueryCityInfoDTO> dto) {
        PageResult<PageCityInfoDTO> result = cityInfoService.pageQuery(dto);
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
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryCityInfoDTO> dto) {
        List<Tree<String>> result = cityInfoService.treeQuery(dto);
        return Result.success(result);
    }


}
