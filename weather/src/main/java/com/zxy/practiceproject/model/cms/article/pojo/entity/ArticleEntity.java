package com.zxy.practiceproject.model.cms.article.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "cms_article_info", autoResultMap = true)
public class ArticleEntity extends CoreEntity {

       private String categoryId;
       private String title;
       private String content;
       private String author;
}
