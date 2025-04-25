package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity;

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
@TableName(value = "shop_product_details", autoResultMap = true)
public class UserShopOrderDetailsEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;

    @TableField(value = "`order_id`")
    private String orderId;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`product_id`")
    private String productId;
    @TableField(value = "`product_details_id`")
    private String productDetailsId;
    @TableField(value = "`spec_flags`")
    private String specFlags;
    @TableField(value = "`specs`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject specs;
    @TableField(value = "`num`")
    private String num;
    @TableField(value = "`price`")
    private String price;
    @TableField(value = "`amount`")
    private String amount;
    @TableField(value = "`weight`")
    private String weight;
    @TableField(value = "`volume`")
    private String volume;
    @TableField(value = "`integral`")
    private String integral;
    @TableField(value = "`reply_status`")
    private String replyStatus;



}
