package com.zxy.practiceproject.model.crm.userTag.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.userTag.mapper.UserTagCategoryMapper;
import com.zxy.practiceproject.model.crm.userTag.mapper.UserTagMapper;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.UserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagCategoryEntity;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagEntity;
import com.zxy.practiceproject.model.crm.userTag.service.UserTagCategoryService;
import com.zxy.practiceproject.model.crm.userTag.service.UserTagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserTagServiceImpl extends ServiceImpl<UserTagMapper, UserTagEntity> implements UserTagService {
    @Autowired
    private UserTagMapper userTagMapper;

    @Autowired
    private UserTagCategoryMapper userTagCategoryMapper;
    @Autowired
    private UserTagCategoryService userTagCategoryService;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(UserTagDTO userTagDTO) {
        //设置一些基本属性
        userTagDTO.setStatus(0);
        //保存
        this.save(userTagDTO);
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
     * @param userTagDTO
     * @return
     */
    @Override
    public void edit(UserTagDTO userTagDTO) {
        UserTagEntity userTag = new UserTagEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(userTagDTO, userTag);
        //设置更新时间
        userTag.setUpdateTime(new Date());
        //更新数据库
        this.updateById(userTag);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<UserTagEntity>为查询结果列表
     */
    @Override
    public List<UserTagEntity> listQuery(QueryUserTagDTO queryUserTagDTO) {
        //创建查询条件
        LambdaQueryWrapper<UserTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<UserTagEntity> list = userTagMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageUserTagDTO> pageQuery(PageQuery<QueryUserTagDTO> dto) {

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
            List<String> categoryIds = userTagCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageUserTagDTO> page = userTagMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public UserTagDTO show(String id) {
        UserTagDTO userTagDTO = new UserTagDTO();
        //创建查询条件
        LambdaQueryWrapper<UserTagEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(UserTagEntity::getId, id);
        //查询
        UserTagEntity userTagEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(userTagEntity, userTagDTO);
        return userTagDTO;
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
        LambdaUpdateWrapper<UserTagEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(UserTagEntity::getId, id);
        updateWrapper.set(UserTagEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }

    /**
     * 获取树形列表
     *
     * @return
     */
    @Override
    public List<Tree<String>> getTree() {

        /**
         * 数据准备
         */
        //构造不含“全部”的查询条件
        QueryUserTagCategoryDTO queryUserTagCategoryDTO = new QueryUserTagCategoryDTO();
        queryUserTagCategoryDTO.setIncludeRoot("0");
        //查询
        List<UserTagCategoryEntity> categorys = this.userTagCategoryService.listQuery(queryUserTagCategoryDTO);
        List<UserTagEntity> infos = this.list();
        Map<String, List<UserTagEntity>> groupingMap = infos.stream().collect(Collectors.groupingBy(UserTagEntity::getCategoryId));


        List<TreeNode<String>> nodeList = CollUtil.newArrayList();


        for (UserTagCategoryEntity category : categorys) {

            List<UserTagEntity> info = groupingMap.get(category.getId());
            if (CollUtil.isNotEmpty(info)) {
                if(StrUtil.isEmpty(category.getSort())){
                    category.setSort("0");
                }
                /**
                 * 若分类中存在详情项，则添加到树中
                 */
                Map<String, Object> categoryExtra = new HashMap<>();

                nodeList.add(new TreeNode<>(category.getId(), "0", category.getName(), category.getSort()).setExtra(categoryExtra));


                for (UserTagEntity item : info) {
                    if(StrUtil.isEmpty(item.getSort())){
                        item.setSort("0");
                    }
                    Map<String, Object> infoExtra = new HashMap<>();
                    nodeList.add(new TreeNode<>(item.getId(),category.getId(), item.getName(), item.getSort()).setExtra(infoExtra));
                }
            }

        }


        List<Tree<String>> trees = TreeUtil.build(nodeList,"0");
        return trees;
    }

}
