package com.zxy.practiceproject.model.user.shop.userShopOrder.service.serviceImpl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.utils.JwtUtil;
import com.zxy.common.utils.TreeUtils;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import com.zxy.practiceproject.model.crm.user.service.serviceImpl.UserServiceImpl;
import com.zxy.practiceproject.model.crm.userAddress.pojo.entity.UserAddrEntity;
import com.zxy.practiceproject.model.crm.userAddress.service.serviceImpl.UserAddrServiceImpl;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductRecordEntity;
import com.zxy.practiceproject.model.user.shop.productInfo.service.serviceImpl.ProductRecordService;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import com.zxy.practiceproject.model.user.shop.userShopCart.service.serviceImpl.UserShopCartService;
import com.zxy.practiceproject.model.user.shop.userShopOrder.mapper.UserShopOrderMapper;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.*;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.service.UserShopOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserShopOrderServiceImpl extends ServiceImpl<UserShopOrderMapper, UserShopOrderEntity> implements UserShopOrderService {
    @Autowired
    private UserShopOrderMapper userShopOrderMapper;
    @Autowired
    private UserShopCartService userShopCartServiceImpl;
    @Autowired
    private UserAddrServiceImpl userAddressServiceImpl;

    @Autowired
    private ProductRecordService productRecordServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserShopOrderDetailsServiceImpl userShopOrderDetailsServiceImpl;


    /**
     * 获取当前登录者的地址方法
     */
    private UserAddrEntity getCurrentUserAddr(String addressId) {
        return userAddressServiceImpl.getOne(new LambdaQueryWrapper<UserAddrEntity>().eq(UserAddrEntity::getId, addressId));
    }

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void addOrSubmitOrder(SubmitUserShopOrderDTO submitUserShopOrderDTO) {
        //判断传过来的userId是否为当前登录用户
        if (!ObjectUtil.equal(submitUserShopOrderDTO.getUserId(), JwtUtil.getLoginUserId())) {
            throw new RuntimeException("当前用户与传过来的用户不匹配");
        }
        //构建订单
        UserShopOrderEntity order = new UserShopOrderEntity();
        UserEntity user = userServiceImpl.getById(JwtUtil.getLoginUserId());
        order.setUserId(user.getId());
        order.setReceiverName(user.getName());
        order.setReceiverPhone(user.getPhone());

        //remark
        order.setRemark(submitUserShopOrderDTO.getRemark());

        //获取地址信息
        UserAddrEntity addr = getCurrentUserAddr(submitUserShopOrderDTO.getAddressId());
        if (ObjectUtil.isNull(addr)) {
            throw new RuntimeException("地址信息不存在");
        }
        order.setReceiverAddress(addr.getProvinceName() + addr.getCityName() + addr.getDistrictName() + addr.getAddressDetail());



        //TODO 获取vip信息

        //TODO 获取优惠券信息

        //添加商品数量
        Integer goodsNum = 0;
        for (String cartId : submitUserShopOrderDTO.getCartIdsList()) {
            goodsNum += Integer.parseInt(userShopCartServiceImpl.getById(cartId).getNum());
        }
        order.setGoodsNum(goodsNum.toString());

        //计算并保存总价
        order.setTotalAmount(calculateAmount(submitUserShopOrderDTO).getGoodsPrice().toString());

        //保存
        this.save(order);

        //并将购物车中的数据存入orderDetails中
        CartListDTO cartListDTO = new CartListDTO();
        cartListDTO.setOrderId(order.getId());
        cartListDTO.setCartIds(submitUserShopOrderDTO.getCartIdsList());

        userShopOrderDetailsServiceImpl.add(cartListDTO);


        //删除购物车中商品
        userShopCartServiceImpl.removeBatchByIds(submitUserShopOrderDTO.getCartIdsList());
    }


    /**
     * 删除
     *
     * @param
     * @return
     */
    @Override
    public void deleteOneById(String id) {

//        //先判断身份是否为当前登录用户
//        if (!userId.equals(JwtUtil.LOGIN_USER_ID)) {
//            throw new RuntimeException("身份验证失败");
//        }

        //删除
        this.removeById(id);
    }


    /**
     * 编辑
     *
     * @param userShopOrderDTO
     * @return
     */
    @Override
    public void edit(UserShopOrderDTO userShopOrderDTO) {
        UserShopOrderEntity userShopOrder = new UserShopOrderEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(userShopOrderDTO, userShopOrder);
        //设置更新时间
        userShopOrder.setUpdateTime(new Date());
        //更新CategoryIds
//        userShopOrderDTO.setCategoryIds(this.listParentIdsAndSelf(userShopOrderDTO.getCategoryId()));
        //更新数据库
        this.updateById(userShopOrder);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<UserShopOrderEntity> listQuery(QueryUserShopOrderDTO queryConfigDTO) {
        List<UserShopOrderEntity> list = userShopOrderMapper.listQuery(queryConfigDTO);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     *
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageUserShopOrderDTO> pageQuery(PageQuery<QueryUserShopOrderDTO> dto) {

        /**
         * 如果分类是 '0' 全部，则去掉分类查询条件
         */
        if (ObjectUtil.equal(dto.getFilters().getCategoryId(), "0")) {
            dto.getFilters().setCategoryId(null);
        }

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
        IPage<PageUserShopOrderDTO> page = userShopOrderMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     *
     * @param id
     * @return
     */
    @Override
    public UserShopOrderDTO show(String id) {
        UserShopOrderDTO userShopOrderDTO = new UserShopOrderDTO();
        //创建查询条件
        LambdaQueryWrapper<UserShopOrderEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(UserShopOrderEntity::getId, id);
        //查询
        UserShopOrderEntity userShopOrderEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(userShopOrderEntity, userShopOrderDTO);
        return userShopOrderDTO;
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
        LambdaUpdateWrapper<UserShopOrderEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(UserShopOrderEntity::getId, id);
        updateWrapper.set(UserShopOrderEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }

    @Override
    public List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserShopOrderDTO> dto) {
        //先查询出符合条件的 所有种类 及其 子类 和 父类
        List<UserShopOrderEntity> list = this.listQuery(dto.getFilters());
        List<String> ids = list.stream().map(UserShopOrderEntity::getId).collect(Collectors.toList());
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
        for (UserShopOrderEntity item : list) {
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
        String includeRoot = dto.getFilters().getIncludeRoot();
        List<Tree<String>> trees = new ArrayList<>();
        //
        if (includeRoot.equals("1")) {
            trees = TreeUtil.build(nodeList, "-1");
        }
        if (includeRoot.equals("0")) {
            trees = TreeUtil.build(nodeList, "0");
        }

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

    /**
     * 用户订单列表
     *
     * @param
     * @return
     */
    @Override
    public List<UserShopOrderEntity> getUserOrdersList(IdDTO idDTO) {
        //先判断身份是否为当前登录用户
        if (!idDTO.getId().equals(JwtUtil.getLoginUserId())) {
            throw new RuntimeException("身份验证失败");
        }

        //查询数据
        LambdaQueryWrapper<UserShopOrderEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserShopOrderEntity::getUserId, JwtUtil.getLoginUserId());
        List<UserShopOrderEntity> userShopOrderEntities = this.list(queryWrapper);
        return userShopOrderEntities;

    }

    @Override
    public void updateOrderNum(UserShopOrderDTO userShopOrderDTO) {

    }


    @Override
    public void deleteAllById(String userId) {
        //先判断身份是否为当前登录用户
        if (!userId.equals(JwtUtil.getLoginUserId())) {
            throw new RuntimeException("身份验证失败");
        }
        //删除数据
        this.remove(new LambdaQueryWrapper<UserShopOrderEntity>().eq(UserShopOrderEntity::getUserId, userId));
    }

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    @Override
    public OrderDetailsVO getOrderDetails(UserShopOrderDTO userShopOrderDTO) {
        OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
        //补充信息
        //1.设置订单编号
        orderDetailsVO.setOrderNumber("flag" + IdUtil.fastSimpleUUID());

        //2. 计算订单价格
        //2.1构建查询条件
        SubmitUserShopOrderDTO submitUserShopOrderDTO = new SubmitUserShopOrderDTO();
        submitUserShopOrderDTO.setCartIdsList(userShopOrderDTO.getCartIds());
        submitUserShopOrderDTO.setUserId(userShopOrderDTO.getUserId());
        submitUserShopOrderDTO.setAddressId(userShopOrderDTO.getAddressId());
        submitUserShopOrderDTO.setCouponId(userShopOrderDTO.getCouponId());
        submitUserShopOrderDTO.setRemark(userShopOrderDTO.getRemark());
        submitUserShopOrderDTO.setIntegralPromotionAmount(userShopOrderDTO.getIntegralPromotionAmount());
        submitUserShopOrderDTO.setIntegralPromotionAmount(userShopOrderDTO.getIntegralPromotionAmount());
        //查询并赋值
        String shouldPayAmount = calculateAmount(submitUserShopOrderDTO).getShouldPayAmount();
        orderDetailsVO.setOrderPrice(shouldPayAmount);

        //3.设置订单地址
        UserAddrEntity addr = getCurrentUserAddr(userShopOrderDTO.getAddressId());
        orderDetailsVO.setReceiveAddress(addr.getName() + "  " + addr.getPhone() + "  " + addr.getProvinceName() + addr.getCityName() + addr.getDistrictName() + addr.getAddressDetail());

        //4.设置订单商品名字
        List<UserShopCartEntity> carts = userShopCartServiceImpl.list(new LambdaQueryWrapper<UserShopCartEntity>().eq(UserShopCartEntity::getUserId, userShopOrderDTO.getUserId()));
        //carts只取names放一个集合，并去重
        List<String> orderNames = carts.stream().map(UserShopCartEntity::getName).collect(Collectors.toList());
        orderNames = orderNames.stream().distinct().collect(Collectors.toList());
        orderDetailsVO.setOrderNames(orderNames);


        return orderDetailsVO;
    }


    /**
     * 确定订单  confirmOrder
     *
     * @param
     * @return
     */
    @Override
    public ConfirmOrderVO confirmOrder(List<String> cartIdsList) {
        ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();

        confirmOrderVO.setOrders(userShopCartServiceImpl.list(new LambdaQueryWrapper<UserShopCartEntity>().eq(UserShopCartEntity::getUserId, JwtUtil.getLoginUserId()).in(UserShopCartEntity::getId, cartIdsList)));
        confirmOrderVO.setCoupon("");
        confirmOrderVO.setIntegral("");
        return confirmOrderVO;
    }

    /**
     * 计算运费
     */
    private BigDecimal calculateDeliveryAmount(List<String> cartIdsList) {
        //TODO　计算商品的总运费
        BigDecimal result = BigDecimal.ZERO;
        //计算商品的总运费
        for (String cartId : cartIdsList) {
            UserShopCartEntity cart = userShopCartServiceImpl.getById(cartId);
            ProductRecordEntity product = productRecordServiceImpl.getById(cart.getProductDetailsId());
            product.getWeight();

//            result = result.add(cart.getDeliveryAmount());
        }
        return result;
    }

    /**
     * 计算金额  calculateAmount
     *
     * @param
     * @return
     */
    @Override
    public AmountDetailsVO calculateAmount(SubmitUserShopOrderDTO submitUserShopOrderDTO) {
        AmountDetailsVO amountDetailsVO = new AmountDetailsVO();
        //地址ID        获得运费
        BigDecimal deliveryAmount = this.calculateDeliveryAmount(submitUserShopOrderDTO.getCartIdsList());
        //购物车ID列表   商品价格总和          字段goods_amount
        BigDecimal productPriceTotal = this.calculateProductPriceTotal(submitUserShopOrderDTO.getCartIdsList());
        //商品数量
        Integer goodsNum = 0;
        for (String cartId : submitUserShopOrderDTO.getCartIdsList()) {
            UserShopCartEntity cart = userShopCartServiceImpl.getById(cartId);
            goodsNum += Integer.parseInt(cart.getNum());
        }

        //TODO vip优惠价格
        BigDecimal vipAmount = new BigDecimal("0");

        //TODO 优惠券ID    优惠力度
        BigDecimal couponAmount = new BigDecimal("0");
        //积分抵扣价格
        BigDecimal integralPromotionAmount = new BigDecimal(submitUserShopOrderDTO.getIntegralPromotionAmount());

        BigDecimal shouldPayAmount = deliveryAmount.add(productPriceTotal).subtract(integralPromotionAmount).subtract(couponAmount);

        //设置属性
        amountDetailsVO.setDeliveryAmount(deliveryAmount.toString());
        amountDetailsVO.setGoodsPrice(productPriceTotal.toString());
        amountDetailsVO.setIntegrationAmount(integralPromotionAmount.toString());
        amountDetailsVO.setVipAmount(vipAmount.toString());
        amountDetailsVO.setPromotionAmount(couponAmount.toString());
        amountDetailsVO.setGoodsNum(goodsNum.toString());
        amountDetailsVO.setShouldPayAmount(shouldPayAmount.toString());

        //保存到订单信息
        return amountDetailsVO;
    }

    /**
     * 获得商品价格总和
     *
     * @param cartIdsList
     * @return
     */
    private BigDecimal calculateProductPriceTotal(List<String> cartIdsList) {
        //获取商品Id集合
        List<UserShopCartEntity> carts = userShopCartServiceImpl.list(new LambdaQueryWrapper<UserShopCartEntity>().in(UserShopCartEntity::getId, cartIdsList));
        BigDecimal totalPrice = carts.stream()
                .map(cart -> {
                    // 将数量和价格转换为 BigDecimal
                    BigDecimal num = new BigDecimal(cart.getNum());
                    BigDecimal price = new BigDecimal(cart.getPrice());
                    // 计算每个商品的总价
                    return num.multiply(price);
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice;
    }

    //获取自身种类id和所有父级id，返回List<String>
    public List<String> listParentIdsAndSelf(String id) {
        List<Tree<String>> trees = this.getTree("1");
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
    public Tree<String> getTree() {
        return this.getTree("1").get(0);
    }

    /**
     * 获取树
     *
     * @param
     * @return
     */
    public List<Tree<String>> getTree(String includeRoot) {
        //先查询出所有种类
        List<UserShopOrderEntity> list = this.list();
        //如果种类列表为空，直接返回
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        //将list转化成树节点列表
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (UserShopOrderEntity item : list) {
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
        List<Tree<String>> trees = new ArrayList<>();
        //
        if (includeRoot.equals("1")) {
            trees = TreeUtil.build(nodeList, "-1");
        }
        if (includeRoot.equals("0")) {
            trees = TreeUtil.build(nodeList, "0");
        }

        if (CollUtil.isEmpty(trees)) {
            return new ArrayList<>();
        }
        return trees;
    }


}
