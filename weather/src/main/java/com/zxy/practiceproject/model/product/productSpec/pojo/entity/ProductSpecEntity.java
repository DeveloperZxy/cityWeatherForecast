package com.zxy.practiceproject.model.product.productSpec.pojo.entity;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.ProductAttrDTO;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;
import java.util.List;


@Data

@TableName(value = "product_spec", autoResultMap = true)
public class ProductSpecEntity extends CoreEntity {
    private String categoryId;

    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;

    @TableField(value = "`attrs`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<ProductAttrDTO> attrs ;

    public List<ProductAttrDTO> getAttrs() {
        if(CollUtil.isEmpty(attrs)){
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(attrs,ProductAttrDTO.class);
    }


}
