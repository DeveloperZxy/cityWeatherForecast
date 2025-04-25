<template>
  <el-dialog v-model="dialogShow" title="修改密码">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="原始密码" prop="oldPassword">
        <el-input
          v-model="formData.oldPassword"
          maxlength="11"
          clearable
          placeholder="请输入原始密码"
          type="password"
        />
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input
          v-model="formData.newPassword"
          maxlength="11"
          clearable
          placeholder="请输入新密码"
          type="password"
        />
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input
          v-model="formData.confirmPassword"
          maxlength="11"
          clearable
          placeholder="请输入确认密码"
          type="password"
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
import * as tplCategoryApi from "@/api/crm/user/userInfoApi";

import {ref, reactive, defineExpose, defineEmits} from "vue";
import {handleTree} from "@/utils/tree";
import {ElMessage} from "element-plus";
import error from "@/router/modules/error";

const dialogShow = ref(false);
const formRef = ref();
const formData = reactive({
  id: "",
  name: "",
  parentId: "",
  oldPassword: "",
  confirmPassword: "",
  newPassword: ""
});

const emit = defineEmits(["success"]);
//将这个方法暴露出去，供父组件调用

const open = async (id?: any) => {
  clearFrom();
  dialogShow.value = true;
  formData.id = id;
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
  console.log("修改密码前", formData);
  //先确认新密码与确认密码是否一致
  if (formData.newPassword !== formData.confirmPassword) {
    ElMessage({
      type: "error",
      message: "新密码与确认密码不一致，请重新输入"
    });
    return;
  }
  console.log("修改密码前", formData);
  const data = {
    id: formData.id,
    oldPassword: formData.oldPassword,
    newPassword: formData.newPassword
  };
 let res= await tplCategoryApi.getChangePasswordApi(data);
  if (res.success) {
    ElMessage({
      type: "success",
      message: "修改密码成功,请重新登录",
      duration: 1000,
      // TODO 跳转到登陆页面
      onClose: () => {
        window.location.href = "/login";
      }
    });
  } else {
    // TODO 抛出后台报错信息  error.message
    ElMessage({
      type: "error",
      message: error.message || "修改密码失败，请稍后再试"
    });
    // ElMessage({
    //   type: "error",
    //   message:  res.message || "修改密码失败，请稍后再试"
    // });
  }
  emit("success");
  //表单校验
  dialogShow.value = false;
  clearFrom();
};

//指定规格
const rules = reactive({
  oldPassword: [
    {required: true, message: "请输入分类", trigger: "blur"},
    // {min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur"}
  ],
  newPassword: [
    {required: true, message: "请输入标题", trigger: "blur"},
    // { min: 3, max: 5, message: "长度在 3 到5 个字符", trigger: "blur" }
  ],
  confirmPassword: [
    {required: true, message: "请输入标题", trigger: "blur"},
    // { min: 3, max: 5, message: "长度在 3 到5 个字符", trigger: "blur" }
  ]
});

//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
