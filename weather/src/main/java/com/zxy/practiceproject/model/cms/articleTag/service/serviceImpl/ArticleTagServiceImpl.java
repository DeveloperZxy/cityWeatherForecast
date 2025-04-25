package com.zxy.practiceproject.model.cms.articleTag.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.cms.articleTag.mapper.ArticleTagCategoryMapper;
import com.zxy.practiceproject.model.cms.articleTag.mapper.ArticleTagMapper;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.ArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.service.ArticleTagService;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTagEntity> implements ArticleTagService {
    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private ArticleTagCategoryMapper articleTagCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(ArticleTagDTO articleTagDTO) {
        //设置一些基本属性
        articleTagDTO.setStatus(0);
        //保存
        this.save(articleTagDTO);
    }


    /**
     * 删除
     *
     * @param
     * @return
     */
    @Override
    public void del(IdDTO idDTO) {
        this.removeById(idDTO.getId());
    }


    /**
     * 编辑
     *
     * @param articleTagDTO
     * @return
     */
    @Override
    public void edit(ArticleTagDTO articleTagDTO) {
        ArticleTagEntity articleTag = new ArticleTagEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(articleTagDTO, articleTag);
        //设置更新时间
        articleTag.setUpdateTime(new Date());
        //更新数据库
        this.updateById(articleTag);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<UserTagEntity>为查询结果列表
     */
    @Override
    public List<ArticleTagEntity> listQuery(QueryArticleTagDTO queryUserTagDTO) {
        //创建查询条件
        LambdaQueryWrapper<ArticleTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<ArticleTagEntity> list = articleTagMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageArticleTagDTO> pageQuery(PageQuery<QueryArticleTagDTO> dto) {

        /**
         * 如果分类是 '0' 全部，则去掉分类查询条件
         */
        if(ObjectUtil.equal(dto.getFilters().getCategoryId(),"0")){
            dto.getFilters().setCategoryId(null);
        }

        //接收前端发送的时间段 数组，拆开并塞值     设置时间范围
        //这是Java层面处理时间
//        if(ArrayUtil.isNotEmpty(dto.getFilters().getCreatedTime())){
//            dto.getFilters().setCreationTimeStart(DateUtil.beginOfDay(dto.getFilters().getCreatedTime()[0]));
//            dto.getFilters().setCreationTimeEnd(DateUtil.endOfDay(dto.getFilters().getCreatedTime()[1]));
//        }

        //查询要查询的   分类id 及其 子分类id    将这些id存起来
        String categoryId = dto.getFilters().getCategoryId();
        if(StrUtil.isNotBlank(categoryId)){
            List<String> categoryIds = articleTagCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageArticleTagDTO> page = articleTagMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public ArticleTagDTO show(String id) {
        ArticleTagDTO articleTagDTO = new ArticleTagDTO();
        //创建查询条件
        LambdaQueryWrapper<ArticleTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(ArticleTagEntity::getId, id);
        //查询
        ArticleTagEntity articleTagEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(articleTagEntity, articleTagDTO);
        return articleTagDTO;
    }

    /**
     * 设置状态
     *
     * @param id
     * @param status
     */
    @Override
    public void setStatus(String id, Integer status) {
        //创建更新条件
        LambdaUpdateWrapper<ArticleTagEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(ArticleTagEntity::getId, id);
        updateWrapper.set(ArticleTagEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }
}
