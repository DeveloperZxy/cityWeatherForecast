package com.zxy.practiceproject.model.weather.cityCare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.PageCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.QueryCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.CityCareInfoEntity;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.DetailsCityCareEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityCareInfoMapper extends BaseMapper<CityCareInfoEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageCityCareInfoDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryCityCareInfoDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<CityCareInfoEntity> listQuery(QueryCityCareInfoDTO queryConfigDTO);


    List<DetailsCityCareEntity> listQueryWithJoin(@Param("scan") QueryCityCareInfoDTO queryConfigDTO);
}
