package com.zxy.practiceproject.model.product.productTag.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.product.productTag.mapper.ProductTagCategoryMapper;
import com.zxy.practiceproject.model.product.productTag.mapper.ProductTagMapper;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.ProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagEntity;
import com.zxy.practiceproject.model.product.productTag.service.ProductTagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductTagServiceImpl extends ServiceImpl<ProductTagMapper, ProductTagEntity> implements ProductTagService {
    @Autowired
    private ProductTagMapper productTagMapper;

    @Autowired
    private ProductTagCategoryMapper productTagCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(ProductTagDTO productTagDTO) {
        //设置一些基本属性
        productTagDTO.setStatus(0);
        //保存
        this.save(productTagDTO);
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
     * @param productTagDTO
     * @return
     */
    @Override
    public void edit(ProductTagDTO productTagDTO) {
        ProductTagEntity productTag = new ProductTagEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(productTagDTO, productTag);
        //设置更新时间
        productTag.setUpdateTime(new Date());
        //更新数据库
        this.updateById(productTag);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<ProductTagEntity> listQuery(QueryProductTagDTO queryConfigDTO) {
        //创建查询条件
        LambdaQueryWrapper<ProductTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<ProductTagEntity> list = productTagMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageProductTagDTO> pageQuery(PageQuery<QueryProductTagDTO> dto) {

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
            List<String> categoryIds = productTagCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageProductTagDTO> page = productTagMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public ProductTagDTO show(String id) {
        ProductTagDTO productTagDTO = new ProductTagDTO();
        //创建查询条件
        LambdaQueryWrapper<ProductTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(ProductTagEntity::getId, id);
        //查询
        ProductTagEntity productTagEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(productTagEntity, productTagDTO);
        return productTagDTO;
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
        LambdaUpdateWrapper<ProductTagEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(ProductTagEntity::getId, id);
        updateWrapper.set(ProductTagEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }

    @Override
    public void setMobileShow(String id, String mobileShow) {
        //创建更新条件
        LambdaUpdateWrapper<ProductTagEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(ProductTagEntity::getId, id);
        updateWrapper.set(ProductTagEntity::getMobileShow, mobileShow);
        //更新状态
        this.update(updateWrapper);
    }
}
