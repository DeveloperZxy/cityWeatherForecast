package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;
import lombok.Data;

import java.util.List;

@Data
public class ConfirmOrderVO {

  private List<UserShopCartEntity>  orders;

  /**
   * 用户积分
   */
  private String integral;

  /**
   * 优惠券信息
   */
  private String  coupon;




}
