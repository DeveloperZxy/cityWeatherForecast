package com.zxy.practiceproject.model.system.dict.pojo.dto;

import com.zxy.practiceproject.model.system.dict.pojo.entity.DictEntity;
import lombok.Data;

@Data
public class DictDTO extends DictEntity {
    private String categoryId;
}
