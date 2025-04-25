package com.zxy.common.result;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.Data;

@Data
public class PageQuery<T> {
    /**
     * 页码
     */
    private Long num;
    /**
     * 每页数量
     */
    private Long size;
    /**
     * 总条数
     */
    private Long total;

    /**
     * 过滤参数
     */
    private T filters;

    public Page<T> getPageable() {
        Page<T> page = new Page<>(this.getNum(), this.getSize());
        return page;
    }

}
