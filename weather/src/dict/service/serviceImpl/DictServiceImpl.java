package com.zxy.dict.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.dict.mapper.DictCategoryMapper;
import com.zxy.dict.mapper.DictMapper;
import com.zxy.dict.pojo.dto.DictDTO;
import com.zxy.dict.pojo.dto.PageDictDTO;
import com.zxy.dict.pojo.dto.QueryDictDTO;
import com.zxy.dict.pojo.entity.DictEntity;
import com.zxy.dict.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity> implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private DictCategoryMapper dictCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(DictDTO dictDTO) {
        //设置一些基本属性
        dictDTO.setCode("0");
        dictDTO.setStatus(0);
        //保存
        this.save(dictDTO);
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
     * @param dictDTO
     * @return
     */
    @Override
    public void edit(DictDTO dictDTO) {
        DictEntity dict = new DictEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(dictDTO, dict);
        //设置更新时间
        dict.setUpdateTime(new Date());
        //更新数据库
        this.updateById(dict);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<DictEntity> listQuery(QueryDictDTO queryConfigDTO) {
        //创建查询条件
        LambdaQueryWrapper<DictEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<DictEntity> list = dictMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageDictDTO> pageQuery(PageQuery<QueryDictDTO> dto) {

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
            List<String> categoryIds = dictCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageDictDTO> page = dictMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     * @param id
     * @return
     */
    @Override
    public DictDTO show(String id) {
        DictDTO dictDTO = new DictDTO();
        //创建查询条件
        LambdaQueryWrapper<DictEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(DictEntity::getId, id);
        //查询
        DictEntity dictEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(dictEntity, dictDTO);
        return dictDTO;
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
        LambdaUpdateWrapper<DictEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(DictEntity::getId, id);
        updateWrapper.set(DictEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }
}
