package com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "shop_product_record", autoResultMap = true)
public class ProductRecordEntity extends CoreEntity {
    private String categoryId;

    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`product_id`")
    private String productId;
    @TableField(value = "`specs`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject specs;
    @TableField(value = "`spec_flag`")
    private String specFlag;
    @TableField(value = "`original_price`")
    private String originalPrice;
    @TableField(value = "`cost_price`")
    private String costPrice;
    @TableField(value = "`price`")
    private String price;
    @TableField(value = "`bar_code`")
    private String barCode;
    @TableField(value = "`inventory`")
    private String inventory;
    @TableField(value = "`weight`")
    private String weight;
    @TableField(value = "`volume`")
    private String volume;
}
