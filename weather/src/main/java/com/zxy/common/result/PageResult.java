package com.zxy.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 */
@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {
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
     * 列表
     */
    private List<T> list;

    /**
     * 无参构造器
     */
    public PageResult() {
    }


    /**
     * MyBatis Plus 分页封装
     * @param page
     */
    public  PageResult(IPage<T> page){
        this.num=page.getCurrent();
        this.size=page.getSize();
        this.total=page.getTotal();
        this.list=page.getRecords();
    }

}
