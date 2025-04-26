<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="城市选择" prop="name">
        <CitySelect v-model="formData.locationId"></CitySelect>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import * as tplCategoryApi from "@/api/weather/cityCareInfoApi";
import CitySelect from "@/components/Me/CitySelect.vue";
import {ref, reactive, defineExpose, defineEmits} from "vue";


const title = ref("");
const dialogShow = ref(false);
const formRef = ref();
const formData = reactive({
  id: "",
  name: "",
  parentId: "",
  locationId: "",
  cityId:""
});

const emit = defineEmits(["success"]);
//将这个方法暴露出去，供父组件调用
const open = async () => {
  dialogShow.value = true;
  title.value = "新增";
  clearFrom();
  onAddForm();

};

//onAddForm提交方法
const onAddForm = async () => {
};

const onEditForm = async (id: string) => {
  clearFrom();
  try {
    const res = await tplCategoryApi.getShowApi(id);
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
    formData.cityId=formData.locationId;
    await tplCategoryApi.getAddApi(formData);
  } else {
    await tplCategoryApi.getEditApi(formData);
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
