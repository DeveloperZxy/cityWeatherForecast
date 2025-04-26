package com.zxy.practiceproject.model.weather.city.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.weather.city.pojo.dto.PageCityInfoDTO;
import com.zxy.practiceproject.model.weather.city.pojo.dto.QueryCityInfoDTO;
import com.zxy.practiceproject.model.weather.city.pojo.entity.CityInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityInfoMapper extends BaseMapper<CityInfoEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageCityInfoDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryCityInfoDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<CityInfoEntity> listQuery(QueryCityInfoDTO queryConfigDTO);
}
