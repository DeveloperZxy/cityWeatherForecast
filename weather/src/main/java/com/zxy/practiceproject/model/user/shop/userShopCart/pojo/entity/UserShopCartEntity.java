package com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "shop_cart_info", autoResultMap = true)
public class UserShopCartEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;

    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`product_id`")
    private String productId;
    @TableField(value = "`product_details_id`")
    private String productDetailsId;
    @TableField(value = "`price`")
    private String price;
    @TableField(value = "`num`")
    private String num;



}
