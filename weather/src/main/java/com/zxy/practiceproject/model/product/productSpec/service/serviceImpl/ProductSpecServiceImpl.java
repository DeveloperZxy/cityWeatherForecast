package com.zxy.practiceproject.model.product.productSpec.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.utils.TreeUtils;
import com.zxy.practiceproject.model.product.productSpec.mapper.ProductSpecMapper;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.PageProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.ProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.QueryProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.entity.ProductSpecEntity;
import com.zxy.practiceproject.model.product.productSpec.service.ProductSpecService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpecEntity> implements ProductSpecService {
    @Autowired
    private ProductSpecMapper productSpecMapper;


    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(ProductSpecDTO productTagDTO) {
        //设置一些基本属性
        productTagDTO.setStatus(0);

        productTagDTO.setCategoryIds(this.listParentIdsAndSelf(productTagDTO.getCategoryId()));
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
    public void edit(ProductSpecDTO productTagDTO) {
        ProductSpecEntity productTag = new ProductSpecEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(productTagDTO, productTag);
        //设置更新时间
        productTag.setUpdateTime(new Date());
        //更新CategoryIds
        productTagDTO.setCategoryIds(this.listParentIdsAndSelf(productTagDTO.getCategoryId()));
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
    public List<ProductSpecEntity> listQuery(QueryProductSpecDTO queryConfigDTO) {
        List<ProductSpecEntity> list = productSpecMapper.listQuery(queryConfigDTO);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageProductSpecDTO> pageQuery(PageQuery<QueryProductSpecDTO> dto) {

//        /**
//         * 如果分类是 '0' 全部，则去掉分类查询条件
//         */
//        if(ObjectUtil.equal(dto.getFilters().getCategoryId(),"0")){
//            dto.getFilters().setCategoryId(null);
//        }

        //接收前端发送的时间段 数组，拆开并塞值     设置时间范围
        //这是Java层面处理时间
//        if(ArrayUtil.isNotEmpty(dto.getFilters().getCreatedTime())){
//            dto.getFilters().setCreationTimeStart(DateUtil.beginOfDay(dto.getFilters().getCreatedTime()[0]));
//            dto.getFilters().setCreationTimeEnd(DateUtil.endOfDay(dto.getFilters().getCreatedTime()[1]));
//        }

//        //查询要查询的   分类id 及其 子分类id    将这些id存起来
//        String categoryId = dto.getFilters().getCategoryId();
//        if(StrUtil.isNotBlank(categoryId)){
//            List<String> categoryIds = productBCategoryMapper.listChildrenIdsAndSelf(categoryId);
//            //将这些id 存在拦截器条件里
//            dto.getFilters().setCategoryIds(categoryIds);
//        }

        //查询分页数据
        IPage<PageProductSpecDTO> page = productSpecMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public ProductSpecDTO show(String id) {
        ProductSpecDTO productTagDTO = new ProductSpecDTO();
        //创建查询条件
        LambdaQueryWrapper<ProductSpecEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(ProductSpecEntity::getId, id);
        //查询
        ProductSpecEntity productTagEntity = this.getOne(queryWrapper);
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
        LambdaUpdateWrapper<ProductSpecEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(ProductSpecEntity::getId, id);
        updateWrapper.set(ProductSpecEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }

    @Override
    public List<Tree<String>> treeQuery(TreeQueryDTO<QueryProductSpecDTO> dto) {
        //先查询出符合条件的 所有种类 及其 子类 和 父类
        List<ProductSpecEntity> list = this.listQuery(dto.getFilters());
        List<String> ids = list.stream().map(ProductSpecEntity::getId).collect(Collectors.toList());
        List<String> newIds = new ArrayList<>();
        if (CollUtil.isNotEmpty(ids)) {
            for (String id : ids) {
                List<String> childrenIdsAndSelf = this.listChildrenIdsAndSelf(id);
                List<String> parentsIdsAndSelf = this.listParentIdsAndSelf(id);
                newIds.addAll(childrenIdsAndSelf);
                newIds.addAll(parentsIdsAndSelf);
            }
            //去重
            newIds = newIds.stream().distinct().collect(Collectors.toList());
            //根据ids获取列表
            list = this.listByIds(newIds);

        }

        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        //将list转化成树节点列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (ProductSpecEntity item : list) {
            TreeNode<String> node = new TreeNode<>(item.getId(), item.getCategoryId(), item.getName(), item.getStatus());
            //设置自定义属性并塞值
            Map<String, Object> extra = new HashMap<>();
            extra.put("status", item.getStatus());
            extra.put("description", item.getDescription());
            extra.put("coed", item.getCode());
            extra.put("sort", item.getSort());
            extra.put("createTime", item.getCreateTime());
            node.setExtra(extra);
            nodeList.add(node);
        }
        //再将符合条件的list转化成树，再返回
        List<Tree<String>> trees = TreeUtil.build(nodeList, "-1");
        if (CollUtil.isEmpty(trees)) {
            return new ArrayList<>();
        }
        return trees;
    }

    /**
     * 获取自身种类id所有子节点种类id
     *
     * @param id
     * @return
     */
    @Override
    public List<String> listChildrenIdsAndSelf(String id) {
        List<String> categoryIds = this.baseMapper.listChildrenIdsAndSelf(id);
        if (CollUtil.isEmpty(categoryIds)) {
            return new ArrayList<>();
        }
        return categoryIds;
    }

    //获取自身种类id和所有父级id，返回List<String>
    public List<String> listParentIdsAndSelf(String id) {
        List<Tree<String>> trees = this.getTree();
        if (CollUtil.isEmpty(trees)) {
            return new ArrayList<>();
        }
        Tree<String> tree = trees.get(0);
        Tree<String> node = tree.getNode(id);
        return TreeUtils.getParentsId(node, true);
    }


    /**
     * 获取树
     *
     * @param
     * @return
     */
    public List<Tree<String>> getTree() {
        //先查询出所有种类
        List<ProductSpecEntity> list = this.list();
        //如果种类列表为空，直接返回
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        //将list转化成树节点列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (ProductSpecEntity item : list) {
            TreeNode<String> node = new TreeNode<>(item.getId(), item.getCategoryId(), item.getName(), item.getStatus());
            //设置自定义属性并塞值
            Map<String, Object> extra = new HashMap<>();
            extra.put("status", item.getStatus());
            extra.put("description", item.getDescription());
            extra.put("coed", item.getCode());
            extra.put("sort", item.getSort());
            extra.put("createTime", item.getCreateTime());
            node.setExtra(extra);
            nodeList.add(node);
        }
        //再将符合条件的list转化成树，再返回
        List<Tree<String>> trees = TreeUtil.build(nodeList, "-1");

        return trees;
    }



}
