package com.zxy.practiceproject.model.product.productComment.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;


import java.util.List;


@Data

@TableName(value = "product_comment", autoResultMap = true)
public class ProductCommentEntity extends CoreEntity {
    private String categoryId;

    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;

    private String username;
    private String mark;
    private String reviews;
    private String quality;
    private String serviceAttitude;
    private String logisticsService;
    private String evaluationContent;

}
