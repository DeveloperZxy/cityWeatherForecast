package com.zxy.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CoreEntity {
    private String id;
    @TableField(value = "`description`")
    private String description;
    private String name;
    private Integer status =0;
    private String code;
    private String type;
    private String extend;
    private String sort;
    private String remark;

    private String image;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableLogic
    @TableField(value = "`deleted_status`")
    private String deletedStatus;

}
