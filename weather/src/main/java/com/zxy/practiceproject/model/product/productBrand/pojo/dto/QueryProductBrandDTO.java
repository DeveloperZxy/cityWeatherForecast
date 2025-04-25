package com.zxy.practiceproject.model.product.productBrand.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zxy.common.pojo.entity.QueryEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QueryProductBrandDTO extends QueryEntity {
    /**
     * 是否包含Root    0为不包含Root ，1为包含Root
     */
    private String  includeRoot;


}
