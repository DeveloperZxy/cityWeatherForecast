<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="身份名称" prop="name">
        <el-input v-model="formData.name" placeholder="请输入" />
      </el-form-item>
      <el-form-item prop="status" label="状态" width="68">
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
      <el-form-item label="权限" prop="categoryIds" style="width: 650px">
        <el-tree
          ref="treeRef"
          :data="treeList"
          show-checkbox
          default-expand-all
          node-key="id"
          highlight-current
          :props="defaultProps"
        />
      </el-form-item>

      <!--      <el-form-item label="排序值" prop="sort">-->
      <!--        <el-input-number v-model="formData.sort" :min="0" :max="10000"/>-->
      <!--      </el-form-item>-->
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <!--      <el-button @click="getTree">刷新数据</el-button>-->
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import {
  getAddApi,
  getEditApi,
  getShowApi
} from "@/api/system/roles/rolesInfoApi";
import { getTreeApi } from "@/api/system/permission/permissionInfoApi";

import { ref, reactive, defineExpose, onMounted } from "vue";
import * as productBrandInfoApi from "@/api/system/roles/rolesInfoApi";
import { ElTree } from "element-plus";

const emit = defineEmits(["success"]);

const title = ref("");
const dialogShow = ref(false);
const formRef = ref();
const treeRef = ref<InstanceType<typeof ElTree>>();
const formData = reactive({
  categoryIds: [],
  name: "",
  description: "",
  type: "",
  path: "",
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
      includeRoot: "0"
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
    onAddForm(categoryId);
  } else {
    title.value = "编辑";
    onEditForm(id, categoryId);
  }
  // console.log(categoryItems.value)
};

//onAddForm提交方法
const onAddForm = async (categoryId: string) => {};

const onEditForm = async (id: string, categoryId: string) => {
  clearFrom();
  try {
    const res = await getShowApi(id);
    //将res的值赋给formData
    Object.assign(formData, res.data);
    // 给树形组件赋值勾选
    console.log("getTree获取并勾选", res.data.categoryIds);
    treeRef.value!.setCheckedKeys(res.data.categoryIds, false);
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
  resetTreeRefChecked();
};
//清空树状勾选的方法
const resetTreeRefChecked = () => {
  treeRef.value!.setCheckedKeys([], false);
};

//表单提交方法
const handleFormSubmit = async () => {
  let tempFormData = JSON.parse(JSON.stringify(formData));
  // 获取树形组件选中的节点
  console.log("FormSubmit获取并存储勾选", treeRef.value!.getCheckedKeys(false));
  tempFormData.categoryIds = treeRef.value!.getCheckedKeys();
  if (title.value === "新增") {
    await getAddApi(tempFormData);
  } else {
    await getEditApi(tempFormData);
  }
  emit("success");
  //表单校验
  dialogShow.value = false;
  clearFrom();
  resetTreeRefChecked();
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
