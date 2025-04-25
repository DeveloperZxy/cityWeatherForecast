package com.zxy.practiceproject.model.system.sms.tpl.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "system_sms_tpl_info", autoResultMap = true)
public class TplEntity extends CoreEntity {

       private String categoryId;
}
