<template>
  <div class="image-gallery">
    <div v-for="(imageUrl, index) in imageUrls" :key="index" class="image-item">
      <img
        :src="imageUrl"
        alt="图片"
        class="image"
        @click="previewImage(imageUrl)"
      />
      <div class="icons">
        <el-icon class="icon" @click.stop="previewImage(imageUrl)"
          ><Plus
        /></el-icon>
        <el-icon class="icon" @click.stop="removeImage(index)"
          ><Delete
        /></el-icon>
      </div>
    </div>
    <el-upload
      class="avatar-uploader"
      action="http://127.0.0.1:8080/admin/file/upload/imgs"
      :show-file-list="false"
      :headers="{ authorization: formatToken(getToken().accessToken) }"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
      :http-request="customHttpRequest"
    >
      <el-icon class="avatar-uploader-icon"><Plus /></el-icon>
    </el-upload>
    <el-dialog v-model:visible="dialogVisible" width="50%">
      <img :src="currentImageUrl" alt="Preview" class="preview-image" />
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import { defineProps, defineEmits, computed, ref } from "vue";
import { Plus, Delete } from "@element-plus/icons-vue";
import { getToken, formatToken } from "@/utils/auth";
import type { UploadProps, UploadRequestOptions } from "element-plus";
import axios from "axios";

// 定义 props
const props = defineProps<{
  modelValue: string[];
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

const imageUrls = computed(() => props.modelValue);

const dialogVisible = ref(false);
const currentImageUrl = ref("");

const handleAvatarSuccess: UploadProps["onSuccess"] = (
  response,
  uploadFile
) => {
  console.log("response", response);
  imageUrls.value.push(...response.data);
};

const beforeAvatarUpload: UploadProps["beforeUpload"] = rawFile => {
  return true;
};

// 自定义上传请求
const customHttpRequest = (options: UploadRequestOptions) => {
  const formData = new FormData();
  formData.append("files", options.file);

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

const previewImage = (imageUrl: string) => {
  console.log("previewImage", imageUrl);
  currentImageUrl.value = imageUrl;
  dialogVisible.value = true;
};

const removeImage = (index: number) => {
  imageUrls.value.splice(index, 1);
  emit("update:modelValue", [...imageUrls.value]);
};
</script>

<style scoped>
.image-gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.image-item {
  position: relative;
  width: 100px;
  height: 100px;
  border-radius: 6px;
  overflow: hidden;
  cursor: pointer;
}

.image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.icons {
  position: absolute;
  top: 0;
  right: 0;
  display: flex;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius: 6px;
}

.icon {
  font-size: 16px;
  color: #fff;
  padding: 5px;
  cursor: pointer;
}

.avatar-uploader .avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .avatar-uploader-icon:hover {
  border-color: var(--el-color-primary);
}

.preview-image {
  max-width: 100%;
  max-height: 100%;
}
</style>
