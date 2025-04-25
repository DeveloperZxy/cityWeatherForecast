package com.zxy.practiceproject.model.system.dict.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "system_dict_info", autoResultMap = true)
public class DictEntity extends CoreEntity {

       private String categoryId;
}
