package com.zxy.practiceproject.model.crm.userTag.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "crm_user_tag_info", autoResultMap = true)
public class UserTagEntity extends CoreEntity {
       private String categoryId;
}
