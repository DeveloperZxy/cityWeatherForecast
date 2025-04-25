<template>
  {{ getToken().accessToken }}
  <el-input v-model="proxy" type="hidden" />
  <el-upload
    v-model:file-list="fileList"
    list-type="picture-card"
    :on-preview="handlePictureCardPreview"
    :on-remove="handleRemove"
    :on-change="handleChange"
    :multiple="true"
    :http-request="customHttpRequest"
  >
    <el-icon><Plus /></el-icon>
  </el-upload>

  <el-dialog v-model="dialogVisible">
    <img w-full :src="dialogImageUrl" alt="Preview Image" />
  </el-dialog>
</template>

<script lang="ts" setup>
import { computed, defineEmits, defineProps, ref } from "vue";
import { Plus } from "@element-plus/icons-vue";
import type { UploadProps, UploadUserFile } from "element-plus";
import axios from "axios";
import { ElMessage } from "element-plus";
import { getToken } from "@/utils/auth";

const fileList = ref<UploadUserFile[]>([]);
const dialogImageUrl = ref("");
const dialogVisible = ref(false);

// 定义 props
const props = defineProps<{
  modelValue: string[];
  autoUpload?: boolean; // 默认为 false，不自动上传
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

const handleRemove: UploadProps["onRemove"] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles);
};

const handlePictureCardPreview: UploadProps["onPreview"] = uploadFile => {
  dialogImageUrl.value = uploadFile.url!;
  dialogVisible.value = true;
};

const handleChange = (file, fileList) => {
  if (props.autoUpload) {
    customHttpRequest({ files: fileList, onProgress, onSuccess, onError });
  }
};

// 自定义上传请求
const customHttpRequest = ({ files, onProgress, onSuccess, onError }) => {
  const formData = new FormData();
  files.forEach(file => {
    formData.append("files", file.raw);
  });

  axios
    .post("http://127.0.0.1:8080/admin/file/upload/img", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
        Authorization: "Bearer " + getToken().accessToken
      },
      onUploadProgress: progressEvent => {
        onProgress({
          percent: (progressEvent.loaded / progressEvent.total) * 100
        });
      }
    })
    .then(response => {
      if (response.data.success) {
        onSuccess(response.data, files);
        proxy.value = response.data.url;
      } else {
        onError(response.data);
        ElMessage.error("上传失败，请重试");
      }
    })
    .catch(error => {
      onError(error);
      ElMessage.error("上传失败，请重试");
    });
};

// 定义 onProgress, onSuccess, onError 函数
const onProgress = ({ percent }) => {
  console.log(`Upload progress: ${percent}%`);
};

const onSuccess = (response, files) => {
  console.log("Upload successful:", response);
};

const onError = error => {
  console.error("Upload error:", error);
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

.el-button {
  margin-top: 20px;
}
</style>
