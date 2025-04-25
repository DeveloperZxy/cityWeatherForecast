package com.zxy.practiceproject.model.info.admin.service.serviceImpl;

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
import com.zxy.practiceproject.model.info.admin.mapper.AdminCategoryMapper;
import com.zxy.practiceproject.model.info.admin.mapper.AdminMapper;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminCategoryEntity;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;
import com.zxy.practiceproject.model.info.admin.service.AdminCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminCategoryServiceImpl extends ServiceImpl<AdminCategoryMapper, AdminCategoryEntity> implements AdminCategoryService {
    @Autowired
    private AdminCategoryMapper configCategoryMapper;


    @Autowired
    AdminMapper configMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(AdminCategoryDTO dto) {
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
        //判断当前种类下是否存在ConfigEntity
        boolean exit = configMapper.exists(new LambdaQueryWrapper<AdminEntity>().eq(AdminEntity::getCategoryId, id));
        if (exit) {
            //抛出异常
            throw new RuntimeException("当前种类中存在ConfigEntity，无法删除");
        } else {
            //删除数据
            this.removeById(id);
        }
    }


    /**
     * 编辑
     *
     * @param configCategoryDTO
     * @return
     */
    @Override
    public void edit(AdminCategoryDTO configCategoryDTO) {
        AdminCategoryEntity config = new AdminCategoryEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(configCategoryDTO, config);
        //设置一些基本属性
        configCategoryDTO.setParentIds(this.listParentIdsAndSelf(configCategoryDTO.getParentId()));
        config.setUpdateTime(new Date());
        //更新数据
        this.updateById(config);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<AdminCategoryEntity> listQuery(QueryAdminCategoryDTO queryConfigCategoryDTO) {
        //创建查询种类条件
        LambdaQueryWrapper<AdminCategoryEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        if(ObjectUtil.equal(queryConfigCategoryDTO.getIncludeRoot(),"0")){
            queryWrapper.ne(AdminCategoryEntity::getParentId,"-1");
        }
        //查询
        List<AdminCategoryEntity> list = configCategoryMapper.selectList(queryWrapper);
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
    public PageResult<PageAdminCategoryDTO> pageQuery(PageQuery<QueryAdminCategoryDTO> dto) {
        //分页查询
        IPage<PageAdminCategoryDTO> page = configCategoryMapper.pageQuery(dto.getPageable(), dto.getFilters());
//        //将每个种类插入ConfigEntity
//        for (PageConfigCategoryDTO pageConfigCategoryDTO : page.getRecords()) {
//            //查询当前种类下的ConfigEntity
//            LambdaQueryWrapper<ConfigEntity> queryWrapper1 = new LambdaQueryWrapper<>();
//            queryWrapper1.eq(ConfigEntity::getCategoryId,pageConfigCategoryDTO.getId());
//            List<ConfigEntity> configEntities = configMapper.selectList(queryWrapper1);
//            pageConfigCategoryDTO.setConfigList(configEntities);
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
    public AdminCategoryDTO show(String id) {
        AdminCategoryDTO configCategoryDTO = new AdminCategoryDTO();
        //创建查询条件
        LambdaQueryWrapper<AdminCategoryEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(AdminCategoryEntity::getId, id);
        //查询
        AdminCategoryEntity configCategoryEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(configCategoryEntity, configCategoryDTO);
        //返回
        return configCategoryDTO;
    }


    /**
     * 树形查询
     *
     * @param dto
     * @return
     */
    @Override
    public List<Tree<String>> treeQuery(TreeQueryDTO<QueryAdminCategoryDTO> dto) {
        //先查询出符合条件的 所有种类 及其 子类 和 父类
        List<AdminCategoryEntity> list = configCategoryMapper.listQuery(dto.getFilters());
        List<String> ids = list.stream().map(AdminCategoryEntity::getId).collect(Collectors.toList());
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
        for (AdminCategoryEntity item : list) {
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
        List<AdminCategoryEntity> list = this.list();
        //如果种类列表为空，直接返回
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        //将list转化成树节点列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (AdminCategoryEntity item : list) {
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

