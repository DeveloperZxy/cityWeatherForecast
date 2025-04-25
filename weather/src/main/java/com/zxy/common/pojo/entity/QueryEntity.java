package com.zxy.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QueryEntity {
    private String code;
    private String status;
    private String name;
    private String  keyword;
    private List<String> categoryIds;
    private String categoryId;


    private Date[] createdTime;

    @TableField(exist = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTimeStart;
    @TableField(exist = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date creationTimeEnd;
}
