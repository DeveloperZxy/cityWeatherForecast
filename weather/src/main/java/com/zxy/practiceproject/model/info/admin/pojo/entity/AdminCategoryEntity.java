package com.zxy.practiceproject.model.info.admin.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "info_org_info", autoResultMap = true)
public class AdminCategoryEntity extends CoreEntity {
       private String parentId;
       @TableField(value = "`parent_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
       private List<String> parentIds;
}
