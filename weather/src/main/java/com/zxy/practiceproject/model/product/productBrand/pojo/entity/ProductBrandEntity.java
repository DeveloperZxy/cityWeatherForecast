package com.zxy.practiceproject.model.product.productBrand.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "product_brand", autoResultMap = true)
public class ProductBrandEntity extends CoreEntity {
    private String categoryId;
    private String useNum;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
}
