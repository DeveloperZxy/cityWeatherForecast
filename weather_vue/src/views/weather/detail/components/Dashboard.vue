<template>
  <div>



      <div class="wather-card" >
        <div class="wather-header">
          <span class="wather-time">2025-04-25 09:26</span>
        </div>

        <div class="wather-content">
          <h3 class="wather-title">金水区</h3>
          <div class="wather-content-info">
            <div class="wather-img-wapper">
              <i class="qi-307 wather-img"></i>
              <!--            <img class="wather-img" src="https://a.hecdn.net/img/common/icon/202106d/101.png" alt="">-->
            </div>
            <div class="wather-desc">
              <span class="temperature">20°</span> <span class="value">晴</span>
            </div>
          </div>

        </div>

        <div class="wather-msg">
          今天白天晴，夜晚多云，比昨天热很多，现在21°，空气一般。
        </div>

        <div  class="wather-footer">
          <div class="wather-desc-item" v-for="(item,index) in 7" :key="index">
            <span class="wather-desc-item-name">2级</span>
            <span  class="wather-desc-item-value">南风</span>
          </div>
        </div>

        <div class="wather-warning">
          <img class="wather-warning-img" src="/warning-no-data.png" alt="">
          <span>暂无预警</span>
        </div>
      </div>








  </div>

</template>

<script lang="ts" setup>


import {Position} from "@element-plus/icons-vue";
import {ref} from "vue";




</script>

<style scoped lang="scss">





.wather-card {
  width: 100%;
  background-image: linear-gradient(225deg, #fee5ca, #e9f0ff 55%, #dce3fb);
  border-radius: 16px;
  padding: 24px 30px;
  position: relative;

  .wather-warning{
    //border: 1px solid red;
    width: 90px;
    height: 90px;
    position: absolute;
    left: 0;
    top: 0;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    font-size: 18px;
    font-weight: 500;
    line-height: 22px;
    text-align: center;
    color: red;
  }


  .wather-header{
    display: flex;
    justify-content: end;
    aitems: center;
    .wather-time{
      font-size: 14px;
      line-height: 16px;
      font-weight: 300;
      color: rgba(0, 0, 0, 0.5);
      text-align: right;
    }

  }


  .wather-content {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    aitems: center;
    .wather-title{
      display: flex;
      justify-content: center;
      aitems: center;
    }
    .wather-content-info {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
      font-size: 18px;
      width: 100%;
      .wather-img-wapper{
        display: flex;
        justify-content: center;
        align-items: center;
        width: 110px;
        height: 110px;
        text-align: center;
        .wather-img{
          width: 100%;
          height: 100%;
          font-size: 72px;
        }
      }
      .wather-desc{
        margin-left: 10px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        aitems: center;
        font-size: 15px;
        .temperature{
          font-size: 40px;
          line-height: 1;
          color: black;
          overflow: hidden;
          text-overflow: ellipsis;
        }
        .value{
          font-size: 22px;
          font-weight: 500;
        }
      }
    }
  }

  .wather-msg{
    margin: 26px auto 30px;
    max-width: 514px;
    min-height: 32px;
    font-size: 15px;
    line-height: 1.5;
    text-align: center;
    color: black;
  }

  .wather-footer{


    height: 84px;
    padding: 0 24px;
    border-radius: 12px;
    background-color: rgba(0, 0, 0, 0.03);


    display: flex;
    flex-direction: row;
    .wather-desc-item{
      flex: 1;

      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      .wather-desc-item-name{
        font-size: 18px;
        font-weight: 500;
        line-height: 20px;
        color: black;
        white-space: nowrap;
      }
      .wather-desc-item-value{
        margin-top: 7px;
        font-size: 15px;
        font-weight: normal;
        line-height: 16px;
        color: rgba(0, 0, 0, 0.5);
      }
    }


  }
}
.footer-wapper {
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
}




</style>
