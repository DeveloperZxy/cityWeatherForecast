package com.zxy.common.pojo.dto;

import lombok.Data;

@Data
public class TreeQueryDTO<T> {
    /**
     * 过滤参数
     */
    private T filters;


}
