<template>
  <div class="common-layout">
    <div class="page-wapper">
      <div class="page-aside">
        <slot name="aside" />
      </div>
      <div class="page-body">
        <div class="page-header">
          <slot name="main-top" />
        </div>
        <div class="page-content">
          <slot name="main-content" />
        </div>
      </div>
    </div>

    <!--    <el-container class="">-->
    <!--      <el-aside width="200px">-->
    <!--        &lt;!&ndash;侧边栏&ndash;&gt;-->
    <!--        <slot name="aside"></slot>-->
    <!--      </el-aside>-->
    <!--      <el-container>-->
    <!--        <el-header>-->
    <!--          &lt;!&ndash;主体顶部&ndash;&gt;-->
    <!--          <slot name="main-top"></slot>-->
    <!--        </el-header>-->
    <!--        <el-main>-->
    <!--        &lt;!&ndash;主体内容&ndash;&gt;-->
    <!--          <slot name="main-content"></slot>-->
    <!--        </el-main>-->
    <!--      </el-container>-->
    <!--    </el-container>-->
  </div>
</template>

<script lang="ts" setup></script>

<style lang="scss" scoped>
.page-wapper {
  margin: 20px;
  //border: 1px solid red;
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  height: calc(100vh - 160px);

  .page-aside {
    min-width: 140px;
    max-width: 220px;

    box-sizing: border-box;

    background-color: #fff;
    border-radius: 10px;
    margin-right: 10px;
    padding: 10px;
  }

  .page-body {
    flex: 1;

    display: flex;
    flex-direction: column;

    .page-header {
      //border: 1px solid red;

      background-color: #fff;
      border-radius: 10px;
      padding: 10px;

      margin-bottom: 10px;
    }

    .page-content {
      flex: 1;
      //border: 1px solid red;

      background-color: #fff;
      border-radius: 10px;

      padding: 10px;
    }
  }
}
</style>
