<template>
  <div>
    <el-dialog v-model="dialogShow" title="修改密码">
      <el-form
        :ref="formRef"
        :model="formData"
        :rules="rules"
        label-width="80px"
      >
        <el-form-item label="名称" prop="name">
          <el-input
            v-model="formData.name"
            disabled
            clearable
            placeholder="请输入"
          />
        </el-form-item>
        <el-form-item label="旧密码" prop="oldPassword">
          <el-input
            v-model="formData.oldPassword"
            type="password"
            show-password
            clearable
            placeholder="请输入"
          />
        </el-form-item>
        <el-form-item label="新密码" prop="newPasswordOne">
          <el-input
            v-model="formData.newPasswordOne"
            type="password"
            show-password
            clearable
            placeholder="请输入"
          />
        </el-form-item>
        <el-form-item label="确认新密码" prop="newPasswordTwo">
          <el-input
            v-model="formData.newPasswordTwo"
            type="password"
            show-password
            clearable
            placeholder="请输入"
          />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="handleFormCancle">取 消</el-button>
        <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import { defineEmits, defineExpose, reactive, ref } from "vue";
import * as adminInfoApi from "@/api/info/admin/adminInfoApi";
import { ElMessage } from "element-plus";
const emit = defineEmits(["success"]);
const dialogShow = ref(false);
const formRef = ref();
const formData = reactive({
  id: "",
  name: "",
  oldPassword: "",
  newPasswordOne: "",
  newPasswordTwo: ""
});

const open = async (id?: any) => {
  formData.id = id;
  //数据回显，只回显名字
  let res = await adminInfoApi.getShowApi(id);
  formData.name = res?.data?.name;

  dialogShow.value = true;
};

//onAddForm提交方法
const onAddForm = async () => {};

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
  try {
    // 调用接口
    const res = await adminInfoApi.getSetPasswordApi(formData);

    // 判断接口返回的成功状态
    if (res?.success) {
      // 发出成功事件
      emit("success");
      // 显示成功提示
      ElMessage.success("密码修改成功");
    } else {
      // 显示错误提示
      ElMessage.error(res.message || "密码修改失败，请稍后再试");
    }
  } catch (error) {
    // 捕获异常并显示错误提示
    ElMessage.error("请求失败，请稍后再试");
    console.error("请求失败", error);
  } finally {
    // 关闭对话框
    dialogShow.value = false;
    // 清空表单
    clearFrom();
  }
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

<style scoped lang="scss"></style>
