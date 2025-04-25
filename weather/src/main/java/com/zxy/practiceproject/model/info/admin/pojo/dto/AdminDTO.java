package com.zxy.practiceproject.model.info.admin.pojo.dto;

import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;
import lombok.Data;

@Data
public class AdminDTO extends AdminEntity {
    private String categoryId;
}
