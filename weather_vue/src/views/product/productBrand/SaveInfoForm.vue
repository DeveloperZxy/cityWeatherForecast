<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="分类" prop="categoryId" style="width: 650px">
        <el-tree-select
          v-model="formData.categoryId"
          :data="treeList"
          check-strictly
          node-key="id"
          default-expand-all
          :props="defaultProps"
        />
      </el-form-item>
      <el-form-item label="标签名称" prop="name">
        <el-input v-model="formData.name" placeholder="请输入" />
      </el-form-item>
      <el-form-item label="排序值" prop="sort">
        <el-input-number v-model="formData.sort" :min="0" :max="10000" />
      </el-form-item>
      <el-form-item prop="status" label="是否开启" width="68">
        <el-switch
          v-model="formData.status"
          :active-value="1"
          :inactive-value="0"
          @change="
            () => {
              handleStatusChange(status);
            }
          "
        />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button @click="getTree">刷新数据</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import {
  getAddApi,
  getEditApi,
  getShowApi,
  getTreeApi
} from "@/api/product/productBrand/productBrandInfoApi";

import { ref, reactive, defineExpose, onMounted } from "vue";
import * as productBrandInfoApi from "@/api/product/productBrand/productBrandInfoApi";
const emit = defineEmits(["success"]);

const title = ref("");
const dialogShow = ref(false);
const formRef = ref();

const formData = reactive({
  categoryId: "",
  name: "",
  description: "",
  type: "",
  code: "",
  sort: "",
  id: "",
  status: ""
});

// const props = defineProps({
//   message: []
// });
// const categoryItems = ref(props.message);
// console.log("这里")
// console.log(props.message)
const defaultProps = {
  children: "children",
  label: "name",
  value: "id",
  isLeaf: "leaf",
  emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
};

//改变状态status
const handleStatusChange = async (status: any) => {
  // 发起编辑状态
  if (status == 0) {
    let res = await productBrandInfoApi.getSetStatusApi({
      id: formData.id,
      status: 0
    });
  }
  if (status == 1) {
    let res = await productBrandInfoApi.getSetStatusApi({
      id: formData.id,
      status: 1
    });
  }
};
const treeList = ref([]);
const getTree = async () => {
  let res = await getTreeApi({
    filters: {
      includeRoot: "1"
    }
  });
  treeList.value = res.data;
};

//将这个方法暴露出去，供父组件调用
const open = async (type: string, id?: any, categoryId?: any) => {
  dialogShow.value = true;
  if (type === "add") {
    title.value = "新增";
    //清空数据
    clearFrom();
    //给种类回显赋值
    onAddForm(id);
  } else {
    title.value = "编辑";
    onEditForm(id, categoryId);
  }
  // console.log(categoryItems.value)
};

//onAddForm提交方法
const onAddForm = async (categoryId: string) => {
  formData.categoryId = categoryId;
};

const onEditForm = async (id: string, categoryId: string) => {
  clearFrom();
  try {
    const res = await getShowApi(id);
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
    await getAddApi(formData);
  } else {
    await getEditApi(formData);
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
  //   {min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur"}
  // ],
  // title: [
  //   { required: true, message: "请输入标题", trigger: "blur" },
  //   { min: 3, max: 5, message: "长度在 3 到5 个字符", trigger: "blur" }
  // ]
});
getTree();
//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
