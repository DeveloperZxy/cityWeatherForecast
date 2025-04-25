package com.zxy.practiceproject.model.system.dict.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "system_dict_category", autoResultMap = true)
public class DictCategoryEntity extends CoreEntity {
       private String parentId;
       @TableField(value = "`parent_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
       private List<String> parentIds;
       private String value;
}
