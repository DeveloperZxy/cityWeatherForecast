<template>
  <el-tree-select
    :data="proxy"
    check-strictly
    node-key="id"
    default-expand-all
    :props="defaultProps"
  />
</template>
<script setup>
import { handleTree } from "@/utils/tree";
import * as articleCategoryApi from "@/api/cms/article/articleCategoryApi";
import { onMounted, ref } from "vue";
const defaultProps = {
  children: "children",
  label: "name",
  value: "id",
  isLeaf: "leaf",
  emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
};
// 获取树形数据
const proxy = ref([]);
const getTree = async () => {
  //获取树形数据(前端处理树)    0为不包含Root ，1为包含Root（前后端约定的）
  let response = await articleCategoryApi.getListApi({ includeRoot: "0" });
  const treeDataTemp = response.data;
  //这里是前端手动加上全部
  // treeDataTemp.push({
  //   id: '0',
  //   name: '全部',
  //   parentId: '-1',
  //   sort: 0,
  //   status: 0,
  //   createTime: 1717050623000,
  // })
  proxy.value = handleTree(treeDataTemp);
  console.log("treeDataTempe", treeDataTemp.value);
};

onMounted(() => {
  getTree();
});
</script>

<style scoped></style>
