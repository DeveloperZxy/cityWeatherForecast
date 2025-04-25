package com.zxy.practiceproject.model.product.productTag.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;


@Data
@TableName(value = "product_tag_info", autoResultMap = true)
public class ProductTagEntity extends CoreEntity {
    private String categoryId;
    private String mobileShow;
    private String fontColor;
    private String bgColor;
    private String borderColor;
}
