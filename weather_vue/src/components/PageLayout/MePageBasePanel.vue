<template>
  <!--  <div ref="main" class="MePageBasePanel" >-->
  <!--    <div class="main-top bg-white p-2 mb-3">-->
  <!--      <el-card class="box-card" shadow="never">-->
  <!--      <slot name="main-top"></slot>-->
  <!--      </el-card>-->
  <!--    </div>-->
  <!--    <div class="main-content bg-white  mb-3">-->
  <!--      <el-card class="box-card" shadow="never">-->
  <!--      <slot name="main-content"></slot>-->
  <!--      </el-card>-->
  <!--    </div>-->
  <!--  </div>-->

  <div class="comprehensive-table-container auto-height-container">
    <slot name="main-top" />
    <slot name="main-content" />
  </div>
</template>

<script lang="ts" setup>
/**
 * 定义选项
 */
defineOptions({
  name: "MePageBasePanel"
});
</script>

<style lang="scss" scoped>
.MePageBasePanel {
  margin: 10px;

  .main-top {
    background-color: #ffffff;
  }

  .main-content {
    height: calc(100vh - 50px);
  }
}

.auto-height-container {
  overflow: auto;
}
</style>
