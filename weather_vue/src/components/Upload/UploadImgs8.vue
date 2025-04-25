<template>
  <el-upload
    v-model:file-list="_fileList"
    action="http://127.0.0.1:8080/admin/file/upload/img"
    list-type="picture-card"
    :headers="{ authorization: formatToken(getToken().accessToken) }"
    :on-preview="handlePictureCardPreview"
    :on-remove="handleRemove"
    :on-success="handleSuccess"
  >
    <el-icon><Plus /></el-icon>
  </el-upload>

  <el-dialog v-model="dialogVisible">
    <img w-full :src="dialogImageUrl" alt="Preview Image" />
  </el-dialog>
</template>

<script lang="ts" setup>
/**
 * ["https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100"]
 * [{"name":"food.jpeg","url":"https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100","uid":1742644939767,"status":"success"}]
 */

import { computed, defineEmits, defineProps, onMounted, ref, watch } from "vue";
import { Plus } from "@element-plus/icons-vue";
import type { UploadProps, UploadUserFile } from "element-plus";
import { getToken, formatToken } from "@/utils/auth";

import _ from "lodash";

// 定义 props
const props = defineProps<{
  modelValue: { type: [Array]; default: [] };
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

let proxy = computed({
  get() {
    console.debug("计算属性Get", props.modelValue);
    return props.modelValue;
  },
  set(v) {
    console.debug("计算属性Set", v);
    emit("update:modelValue", v);
  }
});

let _fileList = computed({
  get() {
    let newValue = props.modelValue;
    let temp = [];
    if (newValue && _.isArray(newValue)) {
      newValue.forEach((currentValue, index, arr) => {
        temp.push({
          url: currentValue
        });
      });
    }
    return temp;
  },
  set(v) {}
});

const dialogImageUrl = ref("");
const dialogVisible = ref(false);

const handleRemove: UploadProps["onRemove"] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles);
};

const handleSuccess = (response: any, uploadFile: any, uploadFiles: any) => {
  console.log(response.data);
  uploadFile.url = response.data;
  proxy.value.push(response.data);
};

const handlePictureCardPreview: UploadProps["onPreview"] = uploadFile => {
  dialogImageUrl.value = uploadFile.url!;
  dialogVisible.value = true;
};
</script>
