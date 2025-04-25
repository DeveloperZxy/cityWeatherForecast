<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item v-if="title == '编辑'" label="选择分类" prop="id">
        <el-tree-select
          v-model="formData.parentId"
          :data="categoryList"
          check-strictly
          node-key="id"
          :props="defaultProps"
          default-expand-all
          disabled
          style="width: 240px"
        /> </el-form-item
      ><el-form-item v-if="title == '新增'" label="选择分类" prop="id">
        <el-tree-select
          v-model="formData.parentId"
          :data="categoryList"
          check-strictly
          node-key="id"
          :props="defaultProps"
          default-expand-all
          style="width: 240px"
        />
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="formData.name"
          maxlength="11"
          clearable
          placeholder="请输入名称"
        />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import * as productTagCategoryApi from "@/api/product/productTag/productTagCategoryApi";

import { ref, reactive, defineExpose, defineEmits } from "vue";
import { handleTree } from "@/utils/tree";
const defaultProps = {
  children: "children",
  label: "name",
  value: "id",
  isLeaf: "leaf",
  emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
};
const title = ref("");
const dialogShow = ref(false);
const formRef = ref();
const formData = reactive({
  id: "",
  name: "",
  parentId: ""
});

const emit = defineEmits(["success"]);
//将这个方法暴露出去，供父组件调用
const categoryList = ref([]);
const open = async (type: string, id?: any, categoryId?: any) => {
  //获取树形数据(后端处理的树)
  // const res = await productTagCategoryApi.getTreeApi({});
  // categoryList.value = res.data;

  //获取树形数据(前端处理树)    0为不包含Root ，1为包含Root（前后端约定的）
  let response = await productTagCategoryApi.getListApi({ includeRoot: "0" });
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
  categoryList.value = handleTree(treeDataTemp);

  dialogShow.value = true;
  if (type === "add") {
    title.value = "新增";
    clearFrom();
    formData.parentId = categoryId;
    onAddForm();
  } else {
    title.value = "编辑";
    onEditForm(id);
  }
};

//onAddForm提交方法
const onAddForm = async () => {};

const onEditForm = async (id: string) => {
  clearFrom();
  try {
    const res = await productTagCategoryApi.getShowApi(id);
    console.log("res", res);
    //将res的值赋给formData
    Object.assign(formData, res.data);
  } catch (error) {
    console.error("编辑表单时出错:", error);
  }
};

//清除表单方法
const clearFrom = () => {
  // 清空表单数据
  Object.keys(formData).forEach(key => {
    formData[key] = "";
  });
};

//取消方法
const handleFormCancle = () => {
  dialogShow.value = false;
  clearFrom();
};

//表单提交方法
const handleFormSubmit = async () => {
  if (title.value === "新增") {
    await productTagCategoryApi.getAddApi(formData);
  } else {
    await productTagCategoryApi.getEditApi(formData);
  }
  emit("success");
  //表单校验
  dialogShow.value = false;
  clearFrom();
};

//指定规格
const rules = reactive({
  // categoryId: [
  //   {required: true, message: "请输入分类", trigger: "blur"},
  //   // {min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur"}
  // ],
  // title: [
  //   { required: true, message: "请输入标题", trigger: "blur" },
  //   // { min: 3, max: 5, message: "长度在 3 到5 个字符", trigger: "blur" }
  // ]
});

//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
