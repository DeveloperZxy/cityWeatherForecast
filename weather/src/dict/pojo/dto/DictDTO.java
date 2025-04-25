package com.zxy.dict.pojo.dto;

import com.zxy.dict.pojo.entity.DictEntity;
import lombok.Data;

@Data
public class DictDTO extends DictEntity {
    private String categoryId;
}
