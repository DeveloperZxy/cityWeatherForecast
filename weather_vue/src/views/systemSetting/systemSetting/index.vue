<template>
  <div>
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item prop="status" label="状态" width="68">
        <el-switch
          v-model="formData.status"
          :active-value="1"
          :inactive-value="0"
        />
      </el-form-item>
      <el-form-item v-if="formData.status === 1" label="name" prop="netName">
        <el-input
          v-model="formData.netName"
          maxlength="11"
          clearable
          placeholder="请输入"
        />
      </el-form-item>
      <el-form-item v-if="formData.status === 1" label="addr" prop="netAddress">
        <el-input
          v-model="formData.netAddress"
          maxlength="11"
          clearable
          placeholder="请输入"
        />
      </el-form-item>
      <el-form-item v-if="formData.status === 1" label="phone" prop="phone">
        <el-input
          v-model="formData.phone"
          maxlength="11"
          clearable
          placeholder="请输入"
        />
      </el-form-item>
      <el-form-item v-if="formData.status === 1" label="" prop="netCacheTime">
        <el-input
          v-model="formData.netCacheTime"
          maxlength="11"
          clearable
          placeholder="请输入"
        />
      </el-form-item>
      <el-form-item
        v-if="formData.status === 1"
        label=""
        prop="netRecordNumber"
      >
        <el-input
          v-model="formData.netRecordNumber"
          maxlength="11"
          clearable
          placeholder="请输入"
        />
      </el-form-item>

      <template #footer>
        <el-button
          v-if="formData.status === 1"
          type="primary"
          @click="handleFormSubmit"
          >提 交</el-button
        >
      </template>
    </el-form>
  </div>
</template>

<script lang="ts" setup>
import { onMounted, reactive, ref } from "vue";
import * as ConfigSettingApi from "@/api/systemSetting/configSetting/configSettingApi";

const formData = reactive({
  status: 0,
  netName: "",
  netAddress: "",
  phone: "",
  netCacheTime: "",
  netRecordNumber: ""
});
//
const handleFormSubmit = async () => {
  await ConfigSettingApi.getSaveApi(formData);
};
const showData = async () => {
  await ConfigSettingApi.getShowApi().then(res => {
    formData.netName = res.data.netName;
    formData.netAddress = res.data.netAddress;
    formData.phone = res.data.phone;
    formData.netCacheTime = res.data.netCacheTime;
    formData.netRecordNumber = res.data.netRecordNumber;
  });
};

const rules = reactive({
  //  status: [
  //    { required: true, message: '请选择状态', trigger: 'change' },
  //  ],
  //  netName: [
  //    { required: true, message: '请输入name', trigger: 'blur' },
  //  ],
  //  netAddress: [
  //    { required: true, message: '请输入addr', trigger: 'blur' },
  //  ],
  //  phone: [
  //    { required: true, message: '请输入phone', trigger: 'blur' },
  //  ],
  // netCacheTime: []
});
const formRef = ref();
onMounted(() => {
  showData();
});
</script>

<style scoped lang="scss"></style>
