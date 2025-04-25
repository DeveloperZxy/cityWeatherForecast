package com.zxy.practiceproject.model.info.admin.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "info_admin_info", autoResultMap = true)
public class AdminEntity extends CoreEntity {
       private String categoryId;
       private String phone;
       private String password;
       private String position;
       private String role;
       private String username;

}
