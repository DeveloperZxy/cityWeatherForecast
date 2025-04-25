

<template>
  <div class="daily-temperature-line">

    <el-card >
      <template #header>
        <div class="card-header">
          <h2>24小时温度变化曲线</h2>
        </div>
      </template>
      <e-charts class="chart" :option="option" />
    </el-card>

  </div>




</template>



<script setup>
import { ref,computed } from 'vue';
//模拟数据value的字段对应Y轴，name字段对应X轴
const data=ref([
  {value:11,name:'0:00'},
  {value:31,name:'1:00'},
  {value:75,name:'2:00'},
  {value:25,name:'3:00'},
  {value:16,name:'4:00'},
  {value:16,name:'5:00'},
  {value:16,name:'6:00'},
  {value:16,name:'7:00'},

])

const option=computed(()=>{
  return{
    xAxis:{
      type:'category',
      data:data.value.map(v=>v.name)
    },
    yAxis:{
      type:'value',
      axisLabel: {
        formatter: '{value} °C'
      }
    },
    series:[
      {
        type:'line',
        data:data.value.map(v=>v.value)
      }
    ]
  }
})







// 定时更新数据 每一秒更新一次数据
setInterval(()=>{
  data.value=data.value.map(item=>({
    ...item,
    value:Math.random()*100,  //Math()随机函数，这里是随机生成100以内的数字
  }))
},1000)  //单位ms，1000ms即是1秒
</script>


<style scoped lang="scss">
.daily-temperature-line{
  margin-top: 20px;
}

.chart{
  height: 400px;
}
</style>
