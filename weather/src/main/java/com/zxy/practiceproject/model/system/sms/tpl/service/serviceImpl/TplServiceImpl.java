package com.zxy.practiceproject.model.system.sms.tpl.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.system.sms.tpl.mapper.TplCategoryMapper;
import com.zxy.practiceproject.model.system.sms.tpl.mapper.TplMapper;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.TplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplEntity;
import com.zxy.practiceproject.model.system.sms.tpl.service.TplService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TplServiceImpl extends ServiceImpl<TplMapper, TplEntity> implements TplService {
    @Autowired
    private TplMapper tplMapper;

    @Autowired
    private TplCategoryMapper tplCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(TplDTO tplDTO) {
        //设置一些基本属性
        tplDTO.setStatus(0);
        //保存
        this.save(tplDTO);
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
     * @param tplDTO
     * @return
     */
    @Override
    public void edit(TplDTO tplDTO) {
        TplEntity tpl = new TplEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(tplDTO, tpl);
        //设置更新时间
        tpl.setUpdateTime(new Date());
        //更新数据库
        this.updateById(tpl);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<TplEntity> listQuery(QueryTplDTO queryConfigDTO) {
        //创建查询条件
        LambdaQueryWrapper<TplEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<TplEntity> list = tplMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageTplDTO> pageQuery(PageQuery<QueryTplDTO> dto) {

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
            List<String> categoryIds = tplCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageTplDTO> page = tplMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public TplDTO show(String id) {
        TplDTO tplDTO = new TplDTO();
        //创建查询条件
        LambdaQueryWrapper<TplEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(TplEntity::getId, id);
        //查询
        TplEntity tplEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(tplEntity, tplDTO);
        return tplDTO;
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
        LambdaUpdateWrapper<TplEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(TplEntity::getId, id);
        updateWrapper.set(TplEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }
}
