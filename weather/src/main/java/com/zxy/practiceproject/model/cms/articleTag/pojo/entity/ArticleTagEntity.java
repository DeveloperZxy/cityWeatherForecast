package com.zxy.practiceproject.model.cms.articleTag.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "cms_article_tag_info", autoResultMap = true)
public class ArticleTagEntity extends CoreEntity {
       private String categoryId;
}
