package com.zxy.dict.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QueryDictDTO {
    private String code;
    private String status;

    private List<String> categoryIds;
    private String categoryId;
    private String  keyword;


    private Date[] createdTime;

    @TableField(exist = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTimeStart;
    @TableField(exist = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date creationTimeEnd;

}
