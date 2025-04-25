
<template>
  <div class="daily-forecast">


    <el-card  >
      <template #header>
        <div class="card-header">
          <h2>未来7天天气预报</h2>
        </div>
      </template>
      <el-table  :data="tableData" style="width: 100%">
        <el-table-column prop="fxDate" label="日期" width="180" />

        <el-table-column prop="sunrise" label="日出时间" width="180" />
        <el-table-column prop="sunset" label="日落时间" width="180" />

        <el-table-column prop="moonrise" label="当天月升时间" width="180" />
        <el-table-column prop="moonset" label="当天月落时间" width="180" />
        <el-table-column prop="moonPhase" label="月相名称" width="180" />
        <el-table-column prop="moonPhaseIcon" label="月相" width="180" >
          <template #default="scope">
            <i :class="`qi-${scope.row.iconDay}`" style="font-size: 20px;font-weight: 600"></i>
          </template>
        </el-table-column>


        <el-table-column prop="tempMax" label="当天最高温度" width="180" />
        <el-table-column prop="tempMin" label="当天最低温度" width="180" />



        <el-table-column prop="iconDay" label="天气" width="180" >
          <template #default="scope">
            <i :class="`qi-${scope.row.iconDay}`" style="font-size: 20px;font-weight: 600"></i>
          </template>
        </el-table-column>
        <el-table-column prop="textDay" label="天气状况" width="180" />



        <el-table-column prop="iconNight" label="晚间天气" width="180" >
          <template #default="scope">
            <i :class="`qi-${scope.row.iconDay}`" style="font-size: 20px;font-weight: 600"></i>
          </template>
        </el-table-column>
        <el-table-column prop="textNight" label="晚间天气状况" width="180" />



        <el-table-column prop="wind360Day" label="白天风向360" width="180" />
        <el-table-column prop="windDirDay" label="白天风向" width="180" />
        <el-table-column prop="windScaleDay" label="白天风力等级" width="180" />
        <el-table-column prop="windSpeedDay" label="白天风速(公里/小时)" width="180" />


        <el-table-column prop="wind360Night" label="夜间风向360" width="180" />
        <el-table-column prop="windDirNight" label="夜间风向" width="180" />
        <el-table-column prop="windScaleNight" label="夜间风力等级" width="180" />
        <el-table-column prop="windSpeedNight" label="夜间风速(公里/小时)" width="180" />


        <el-table-column prop="precip" label="天总降水量(毫米)" width="180" />
        <el-table-column prop="uvIndex" label="紫外线强度指数" width="180" />
        <el-table-column prop="humidity" label="相对湿度(百分比数值)" width="180" />
        <el-table-column prop="pressure" label="大气压强(百帕)" width="180" />
        <el-table-column prop="vis" label="能见度(公里)" width="180" />
        <el-table-column prop="cloud" label="云量(百分比数值)" width="180" />



      </el-table>
    </el-card>



  </div>
</template>
<script setup lang="ts">

import {ref} from "vue";

const tableData = ref([
  {
    "fxDate": "2021-11-15",
    "sunrise": "06:58",
    "sunset": "16:59",
    "moonrise": "15:16",
    "moonset": "03:40",
    "moonPhase": "盈凸月",
    "moonPhaseIcon": "803",
    "tempMax": "12",
    "tempMin": "-1",
    "iconDay": "101",
    "textDay": "多云",
    "iconNight": "150",
    "textNight": "晴",
    "wind360Day": "45",
    "windDirDay": "东北风",
    "windScaleDay": "1-2",
    "windSpeedDay": "3",
    "wind360Night": "0",
    "windDirNight": "北风",
    "windScaleNight": "1-2",
    "windSpeedNight": "3",
    "humidity": "65",
    "precip": "0.0",
    "pressure": "1020",
    "vis": "25",
    "cloud": "4",
    "uvIndex": "3"
  },
  {
    "fxDate": "2021-11-16",
    "sunrise": "07:00",
    "sunset": "16:58",
    "moonrise": "15:38",
    "moonset": "04:40",
    "moonPhase": "盈凸月",
    "moonPhaseIcon": "803",
    "tempMax": "13",
    "tempMin": "0",
    "iconDay": "100",
    "textDay": "晴",
    "iconNight": "101",
    "textNight": "多云",
    "wind360Day": "225",
    "windDirDay": "西南风",
    "windScaleDay": "1-2",
    "windSpeedDay": "3",
    "wind360Night": "225",
    "windDirNight": "西南风",
    "windScaleNight": "1-2",
    "windSpeedNight": "3",
    "humidity": "74",
    "precip": "0.0",
    "pressure": "1016",
    "vis": "25",
    "cloud": "1",
    "uvIndex": "3"
  },
  {
    "fxDate": "2021-11-17",
    "sunrise": "07:01",
    "sunset": "16:57",
    "moonrise": "16:01",
    "moonset": "05:41",
    "moonPhase": "盈凸月",
    "moonPhaseIcon": "803",
    "tempMax": "13",
    "tempMin": "0",
    "iconDay": "100",
    "textDay": "晴",
    "iconNight": "150",
    "textNight": "晴",
    "wind360Day": "225",
    "windDirDay": "西南风",
    "windScaleDay": "1-2",
    "windSpeedDay": "3",
    "wind360Night": "225",
    "windDirNight": "西南风",
    "windScaleNight": "1-2",
    "windSpeedNight": "3",
    "humidity": "56",
    "precip": "0.0",
    "pressure": "1009",
    "vis": "25",
    "cloud": "0",
    "uvIndex": "3"
  }
])

</script>

<style scoped lang="scss">

.daily-forecast{

  margin-top: 20px;

  :deep(.el-table){
    .tr,th,td{
      background-color: #F7F8F9 !important;
    }
    background-color: #F7F8F9 !important;
  }



}

</style>
