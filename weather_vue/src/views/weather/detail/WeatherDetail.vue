<template>
  <div style="width: 100%;background-color: #ffffff;;padding: 20px;">

    <div class="container">


      <Dashboard></Dashboard>
      <HourlyForecast></HourlyForecast>
      <DailyForecast></DailyForecast>
      <DailyTemperatureLine></DailyTemperatureLine>
    </div>


  </div>

</template>

<script lang="ts" setup>

import Dashboard from "./components/Dashboard.vue";
import HourlyForecast from "./components/HourlyForecast.vue";
import DailyForecast from "./components/DailyForecast.vue";
import DailyTemperatureLine from "./components/DailyTemperatureLine.vue";
</script>

<style scoped lang="scss">

.container {
  max-width: 1040px;
  padding-left: 20px;
  padding-right: 20px;
  margin-left: auto;
  margin-right: auto;

}


.wather-card {
  width: 100%;
  background-image: linear-gradient(225deg, #fee5ca, #e9f0ff 55%, #dce3fb);
  border-radius: 16px;
  padding: 24px 30px;
  position: relative;

  .wather-warning {
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


  .wather-header {
    display: flex;
    justify-content: end;
    aitems: center;

    .wather-time {
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

    .wather-title {
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

      .wather-img-wapper {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 110px;
        height: 110px;
        text-align: center;

        .wather-img {
          width: 100%;
          height: 100%;
          font-size: 72px;
        }
      }

      .wather-desc {
        margin-left: 10px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        aitems: center;
        font-size: 15px;

        .temperature {
          font-size: 40px;
          line-height: 1;
          color: black;
          overflow: hidden;
          text-overflow: ellipsis;
        }

        .value {
          font-size: 22px;
          font-weight: 500;
        }
      }
    }
  }

  .wather-msg {
    margin: 26px auto 30px;
    max-width: 514px;
    min-height: 32px;
    font-size: 15px;
    line-height: 1.5;
    text-align: center;
    color: black;
  }

  .wather-footer {


    height: 84px;
    padding: 0 24px;
    border-radius: 12px;
    background-color: rgba(0, 0, 0, 0.03);


    display: flex;
    flex-direction: row;

    .wather-desc-item {
      flex: 1;

      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      .wather-desc-item-name {
        font-size: 18px;
        font-weight: 500;
        line-height: 20px;
        color: black;
        white-space: nowrap;
      }

      .wather-desc-item-value {
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
