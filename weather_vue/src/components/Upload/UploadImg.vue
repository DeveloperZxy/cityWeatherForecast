<template>
  <!--  {{ JSON.stringify(props.modelValue) }}-->
  <el-input v-model="proxy" type="hidden" />
  <el-upload
    class="avatar-uploader"
    action="http://127.0.0.1:8080/admin/file/upload/img"
    :show-file-list="false"
    :headers="{ authorization: formatToken(getToken().accessToken) }"
    :on-success="handleAvatarSuccess"
    :before-upload="beforeAvatarUpload"
    :http-request="customHttpRequest"
  >
    <img v-if="imageUrl" :src="imageUrl" class="avatar" />
    <el-icon v-else class="avatar-uploader-icon">
      <Plus />
    </el-icon>
  </el-upload>
</template>

<script lang="ts" setup>
import { defineProps, defineEmits, computed, ref } from "vue";
import { Plus } from "@element-plus/icons-vue";
import { getToken, formatToken } from "@/utils/auth";
import type { UploadProps, UploadRequestOptions } from "element-plus";
import axios from "axios";

// 定义 props
const props = defineProps<{
  modelValue: string;
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

let proxy = computed({
  get() {
    console.debug("计算属性Get", props.modelValue);
    imageUrl.value = props.modelValue;
    return props.modelValue;
  },
  set(v) {
    console.debug("计算属性Set", v);
    emit("update:modelValue", v);
  }
});

const imageUrl = ref(props.modelValue);

const handleAvatarSuccess: UploadProps["onSuccess"] = (
  response,
  uploadFile
) => {
  console.log("response", response);
  proxy.value = response.data;
};

const beforeAvatarUpload: UploadProps["beforeUpload"] = rawFile => {
  // 可以在这里添加文件类型和大小的校验
  // if (rawFile.type !== 'image/jpeg') {
  //   ElMessage.error('Avatar picture must be JPG format!');
  //   return false;
  // } else if (rawFile.size / 1024 / 1024 > 2) {
  //   ElMessage.error('Avatar picture size can not exceed 2MB!');
  //   return false;
  // }
  return true;
};

// 自定义上传请求
const customHttpRequest = (options: UploadRequestOptions) => {
  const formData = new FormData();
  formData.append("file", options.file);

  // 先显示图片
  // imageUrl.value = URL.createObjectURL(options.file);
  // imageUrl.value = props.modelValue;
  axios
    .post(options.action, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
        Authorization: formatToken(getToken().accessToken)
      }
    })
    .then(response => {
      options.onSuccess(response.data);
    })
    .catch(error => {
      options.onError(error);
    });
};
</script>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
