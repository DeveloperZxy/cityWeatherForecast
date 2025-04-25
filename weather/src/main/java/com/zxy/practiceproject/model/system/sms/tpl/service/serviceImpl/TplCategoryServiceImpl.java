package com.zxy.practiceproject.model.system.sms.tpl.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.utils.TreeUtils;
import com.zxy.practiceproject.model.system.sms.tpl.mapper.TplCategoryMapper;
import com.zxy.practiceproject.model.system.sms.tpl.mapper.TplMapper;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.TplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplCategoryEntity;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplEntity;
import com.zxy.practiceproject.model.system.sms.tpl.service.TplCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TplCategoryServiceImpl extends ServiceImpl<TplCategoryMapper, TplCategoryEntity> implements TplCategoryService {
    @Autowired
    private TplCategoryMapper tplCategoryMapper;


    @Autowired
    TplMapper tplMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(TplCategoryDTO dto) {
        //设置一些基本属性
        dto.setParentIds(this.listParentIdsAndSelf(dto.getParentId()));
        //保存数据
        this.save(dto);
    }


    /**
     * 删除
     *
     * @param
     * @return
     */
    @Transactional  //事务注解 ：作用在方法上，表示当前方法执行时，如果其中一步出现异常，则进行回滚
    @Override
    public void del(String id) {
        //判断当前种类下是否存在DictEntity
        boolean exit = tplMapper.exists(new LambdaQueryWrapper<TplEntity>().eq(TplEntity::getCategoryId, id));
        if (exit) {
            //抛出异常
            throw new RuntimeException("当前种类中存在DictEntity，无法删除");
        } else {
            //删除数据
            this.removeById(id);
        }
    }


    /**
     * 编辑
     *
     * @param tplCategoryDTO
     * @return
     */
    @Override
    public void edit(TplCategoryDTO tplCategoryDTO) {
        TplCategoryEntity tpl = new TplCategoryEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(tplCategoryDTO, tpl);
        //设置一些基本属性
        tplCategoryDTO.setParentIds(this.listParentIdsAndSelf(tplCategoryDTO.getParentId()));
        tpl.setUpdateTime(new Date());
        //更新数据
        this.updateById(tpl);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<DictEntity>为查询结果列表
     */
    @Override
    public List<TplCategoryEntity> listQuery(QueryTplCategoryDTO queryDictCategoryDTO) {
        //创建查询种类条件
        LambdaQueryWrapper<TplCategoryEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        if(ObjectUtil.equal(queryDictCategoryDTO.getIncludeRoot(),"0")){
            queryWrapper.ne(TplCategoryEntity::getParentId,"-1");
        }
        //查询
        List<TplCategoryEntity> list = tplCategoryMapper.selectList(queryWrapper);
        //为空时返回空数组
        if(ObjectUtil.isEmpty(list)){
            return new ArrayList<>();
        }
        //返回
        return list;
    }

    /**
     * 分页查询
     *
     * @param dto
     * @return
     */
    @Override
    public PageResult<PageTplCategoryDTO> pageQuery(PageQuery<QueryTplCategoryDTO> dto) {
        //分页查询
        IPage<PageTplCategoryDTO> page = tplCategoryMapper.pageQuery(dto.getPageable(), dto.getFilters());
//        //将每个种类插入DictEntity
//        for (PageDictCategoryDTO pageDictCategoryDTO : page.getRecords()) {
//            //查询当前种类下的DictEntity
//            LambdaQueryWrapper<DictEntity> queryWrapper1 = new LambdaQueryWrapper<>();
//            queryWrapper1.eq(DictEntity::getCategoryId,pageDictCategoryDTO.getId());
//            List<DictEntity> tplEntities = tplMapper.selectList(queryWrapper1);
//            pageDictCategoryDTO.setDictList(tplEntities);
//        }
        //返回
        return new PageResult<>(page);
    }

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    @Override
    public TplCategoryDTO show(String id) {
        TplCategoryDTO tplCategoryDTO = new TplCategoryDTO();
        //创建查询条件
        LambdaQueryWrapper<TplCategoryEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(TplCategoryEntity::getId, id);
        //查询
        TplCategoryEntity tplCategoryEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(tplCategoryEntity, tplCategoryDTO);
        //返回
        return tplCategoryDTO;
    }


    /**
     * 树形查询
     *
     * @param dto
     * @return
     */
    @Override
    public List<Tree<String>> treeQuery(TreeQueryDTO<QueryTplCategoryDTO> dto) {
        //先查询出符合条件的 所有种类 及其 子类 和 父类
        List<TplCategoryEntity> list = tplCategoryMapper.listQuery(dto.getFilters());
        List<String> ids = list.stream().map(TplCategoryEntity::getId).collect(Collectors.toList());
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
        for (TplCategoryEntity item : list) {
            TreeNode<String> node = new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getStatus());
            //设置自定义属性并塞值
            Map<String, Object> extra = new HashMap<>();
            extra.put("status", item.getStatus());
            extra.put("description", item.getDescription());
            extra.put("coed", item.getCode());
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
     * 获取树
     *
     * @param
     * @return
     */
    public List<Tree<String>> getTree() {
        //先查询出所有种类
        List<TplCategoryEntity> list = this.list();
        //如果种类列表为空，直接返回
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        //将list转化成树节点列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (TplCategoryEntity item : list) {
            TreeNode<String> node = new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getStatus());
            //设置自定义属性并塞值
            Map<String, Object> extra = new HashMap<>();
            extra.put("status", item.getStatus());
            extra.put("description", item.getDescription());
            extra.put("coed", item.getCode());
            node.setExtra(extra);
            nodeList.add(node);
        }
        //再将符合条件的list转化成树，再返回
        List<Tree<String>> trees = TreeUtil.build(nodeList, "-1");

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

}

