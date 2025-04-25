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
@TableName(value = "shop_product_info", autoResultMap = true)
public class ProductInfoEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`brand_id`")
    private String brandId;
    @TableField(value = "`brand_name`")
    private String brandName;
    @TableField(value = "`unit_id`")
    private String unitId;
    @TableField(value = "`unit_name`")
    private String unitName;
    @TableField(value = "`images`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private List<String> images;
    @TableField(value = "`recomend_img`")
    private String recomendImg;
    @TableField(value = "`content`")
    private String content;
    @TableField(value = "`keyword`")
    private String keyword;
    @TableField(value = "`tag_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private List<String> tagIds;
    @TableField(value = "`shelf_status`")
    private String shelfStatus;
    @TableField(value = "`shelf_time`")
    private String shelfTime;
    @TableField(value = "`takedown_time`")
    private String takedownTime;
    @TableField(value = "`spec_type`")
    private String specType;
    @TableField(value = "`watchword`")
    private String watchword;
    @TableField(value = "`services`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private List<String> services;
    @TableField(value = "`attrs`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private JSONObject attrs;
    @TableField(value = "`sold_num`")
    private String soldNum;
    @TableField(value = "`give_integral`")
    private String giveIntegral;
    @TableField(value = "`give_coupons`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private List<String> giveCoupons;
    @TableField(value = "`user_tag_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private JSONObject userTagIds;
    @TableField(value = "`limit_status`")
    private String limitStatus;
    @TableField(value = "`limit_type`")
    private String limitType;
    @TableField(value = "`limit_num`")
    private String limitNum;
    @TableField(value = "`presell_status`")
    private String presellStatus;
    @TableField(value = "`presell_time_start`")
    private String presellTimeStart;
    @TableField(value = "`presell_time_end`")
    private String presellTimeEnd;
    @TableField(value = "`recommend_status`")
    private String recommendStatus;
    @TableField(value = "`recommend_product_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private List<String> recommendProductIds;
    @TableField(value = "`activity_priority`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)

    private JSONObject activityPriority;
    @TableField(value = "`delivery_way`")
    private String deliveryWay;
    @TableField(value = "`delivery_type`")
    private String deliveryType;


    @TableField(value = "`delivery_price`")
    private String deliveryPrice;
    @TableField(value = "`delivery_tpl_id`")
    private String deliveryTplId;
    @TableField(value = "`price`")
    private String price;
    @TableField(value = "`original_price`")
    private String originalPrice;
    @TableField(value = "`specs`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject specs;
    @TableField(value = "`score_num`")
    private String scoreNum;


}
