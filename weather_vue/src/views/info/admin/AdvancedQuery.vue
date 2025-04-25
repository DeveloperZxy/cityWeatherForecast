<template>
  <el-dialog v-model="dialogShow" title="高级查询">
    <el-form :ref="formRef" :model="pageFilters" label-width="80px">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="关键词" prop="keyword">
            <el-input
              v-model="pageFilters.keyword"
              placeholder="请输入关键词"
              clearable
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="名称" prop="name">
            <el-input
              v-model="pageFilters.name"
              placeholder="请输入"
              clearable
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="编码" prop="code">
            <el-input
              v-model="pageFilters.code"
              placeholder="请输入"
              clearable
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态">
            <el-switch
              v-model="pageFilters.status"
              :active-value="1"
              :inactive-value="0"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="创建日期">
            <!--            <BusinessDatePicker v-model="pageFilters.createdTime"></BusinessDatePicker>-->
            <el-date-picker
              v-model="pageFilters.createdTime"
              type="daterange"
              range-separator="To"
              start-placeholder="Start date"
              end-placeholder="End date"
              value-format="YYYY/MM/DD HH:mm:ss"
            />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <template #footer>
      <el-button @click="onFromReset">重 置</el-button>
      <el-button @click="onFormCancel">取 消</el-button>
      <el-button type="primary" @click="onFromSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { computed, defineExpose, ref } from "vue";

const dialogShow = ref(false);
const formRef = ref();

const emit = defineEmits(["success", "resetForm"]);

const props = defineProps({
  modelValue: {
    type: [String, Array, Object],
    required: true,
    default: undefined
  }
});
const pageFilters = computed({
  get() {
    return props.modelValue;
  },
  set(v) {
    emit("update:modelValue", v);
  }
});

//重置表单
const onFromReset = () => {
  emit("resetForm");
};

//表单提交
const onFromSubmit = () => {
  // formRef.value.validate((valid) => {
  //   if (valid) {
  //     emit('success', pageFilters.value)
  //     dialogShow.value = false;
  //   }
  // });

  emit("success", pageFilters.value);
  dialogShow.value = false;
};

//取消表单
const onFormCancel = () => {
  dialogShow.value = false;
  onFromReset();
};

//将这个方法暴露出去，供父组件调用
const open = () => {
  dialogShow.value = true;
};
//向外暴露open方法
defineExpose({
  open
});
</script>

<style scoped lang="scss"></style>
