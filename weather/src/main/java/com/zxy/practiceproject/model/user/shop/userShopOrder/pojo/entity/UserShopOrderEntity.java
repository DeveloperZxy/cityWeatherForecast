package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "shop_order_info", autoResultMap = true)
public class UserShopOrderEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;

    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`receiver_name`")
    private String receiverName;
    @TableField(value = "`receiver_phone`")
    private String receiverPhone;
    @TableField(value = "`receiver_address`")
    private String receiverAddress;
    @TableField(value = "`delivery_type`")
    private String deliveryType;
    @TableField(value = "`delivery_code`")
    private String deliveryCode;
    @TableField(value = "`delivery_name`")
    private String deliveryName;
    @TableField(value = "`delivery_num`")
    private String deliveryNum;
    @TableField(value = "`delivery_uid`")
    private String deliveryUid;
    @TableField(value = "`delivery_mark`")
    private String deliveryMark;
    @TableField(value = "`delivery_amount`")
    private String deliveryAmount;
    @TableField(value = "`goods_num`")
    private String goodsNum;
    @TableField(value = "`integral_promotion_amount`")
    private String integralPromotionAmount;
    @TableField(value = "`integral_use`")
    private String integralUse;
    @TableField(value = "`integral_get`")
    private String integralGet;
    @TableField(value = "`integral_back`")
    private String integralBack;
    @TableField(value = "`coupon_promotion_amount`")
    private String couponPromotionAmount;
    @TableField(value = "`coupon_id`")
    private String couponId;
    @TableField(value = "`coupon_user_id`")
    private String couponUserId;
    @TableField(value = "`coupon_data`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject couponData;
    @TableField(value = "`pay_status`")
    private String payStatus;
    @TableField(value = "`pay_amount`")
    private String payAmount;
    @TableField(value = "`pay_time`")
    private String payTime;
    @TableField(value = "`pay_type`")
    private String payType;
    @TableField(value = "`pay_trade_id`")
    private String payTradeId;
    @TableField(value = "`pay_mark`")
    private String payMark;
    @TableField(value = "`refund_status`")
    private String refundStatus;
    @TableField(value = "`refund_reason_wap_img`")
    private String refundReasonWapImg;
    @TableField(value = "`refund_reason_wap_desc`")
    private String refundReasonWapDesc;
    @TableField(value = "`refund_reason_wap`")
    private String refundReasonWap;
    @TableField(value = "`refund_reason_refuse`")
    private String refundReasonRefuse;
    @TableField(value = "`refund_reason_time`")
    private String refundReasonTime;
    @TableField(value = "`refund_amount`")
    private String refundAmount;
    @TableField(value = "`promotion_amount`")
    private String promotionAmount;
    @TableField(value = "`vip_promotion_amount`")
    private String vipPromotionAmount;
    @TableField(value = "`vip_id`")
    private String vipId;
    @TableField(value = "`vip_data`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject vipData;
    @TableField(value = "`goods_amount`")
    private String goodsAmount;
    @TableField(value = "`receivable_amount`")
    private String receivableAmount;
    @TableField(value = "`total_amount`")
    private String totalAmount;
    @TableField(value = "`mark`")
    private String mark;




}
