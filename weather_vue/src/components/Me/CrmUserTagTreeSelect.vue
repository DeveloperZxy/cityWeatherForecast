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
import * as userTagInfoApi from "@/api/crm/userTag/userTagInfoApi";
import { onMounted, ref } from "vue";
const defaultProps = {
  children: "children",
  label: "name",
  value: "name",
  isLeaf: "leaf",
  emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
};
// 获取树形数据
const proxy = ref([]);
const getTree = async () => {
  //获取树形数据(前端处理树)    0为不包含Root ，1为包含Root（前后端约定的）
  let response = await userTagInfoApi.getTreeInfoApi();
  proxy.value = response.data;
  console.log("treeDataTempe", proxy.value);
};

onMounted(() => {
  getTree();
});
</script>

<style scoped></style>
