<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="分类" prop="categoryId" style="width: 650px">
        <!--        <el-tree-select-->
        <!--          v-model="formData.categoryId"-->
        <!--          :data="categoryList"-->
        <!--          check-strictly-->
        <!--          node-key="id"-->
        <!--          default-expand-all-->
        <!--          :props="defaultProps"-->
        <!--        />-->
        <CategoryTreeSelect v-model="formData.categoryId" />
      </el-form-item>

      <el-form-item label="名称" prop="title">
        <el-input v-model="formData.title" placeholder="请输入" />
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input v-model="formData.content" placeholder="请输入" />
        <!--        <CrmUserTagTreeSelect v-model="formData.content" ></CrmUserTagTreeSelect>-->
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <!--        <el-input v-model="formData.author" placeholder="请输入"/>-->
        <!--        <AdminSelect v-model="formData.author"></AdminSelect>-->
        <!--        <SystemDictSelect v-model="formData.type" dict-code="" ></SystemDictSelect>-->
        <SystemDictSelect v-model="formData.author" dictCode="codeCode" />
      </el-form-item>

      <!--          <el-form-item label="名称" prop="name">&ndash;&gt;&ndash;&gt;-->
      <!--        <el-input v-model="formData.name" placeholder="请输入"/>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="描述" prop="description">-->
      <!--        <el-input v-model="formData.description" :rows="2" type="textarea" placeholder="请输入"/>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="类型" prop="type">-->
      <!--        <el-input v-model="formData.type" placeholder="请输入"/>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="编码" prop="code">-->
      <!--        <el-input v-model="formData.code" placeholder="请输入"/>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="值" prop="extend">-->
      <!--        <el-input v-model="formData.extend" :rows="2" type="textarea" placeholder="请输入"/>-->
      <!--      </el-form-item>-->
      <el-form-item label="排序值" prop="sort">
        <el-input-number v-model="formData.sort" :min="0" :max="10000" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button @click="getTree">刷新数据</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import {
  getAddApi,
  getEditApi,
  getShowApi
} from "@/api/cms/article/articleInfoApi";
import * as articleCategoryApi from "@/api/cms/article/articleCategoryApi";
import { ref, reactive, defineExpose, onMounted } from "vue";
import { handleTree } from "@/utils/tree";
import TreeSelect from "@/components/Me/CategoryTreeSelect.vue";
import CrmUserTagTreeSelect from "@/components/Me/CrmUserTagTreeSelect.vue";
import CategoryTreeSelect from "@/components/Me/CategoryTreeSelect.vue";
import AdminSelect from "@/components/Me/AdminSelect.vue";
import SystemDictSelect from "@/components/Me/SystemDictSelect.vue";
const emit = defineEmits(["success"]);

const title = ref("");
const dialogShow = ref(false);
const formRef = ref();

const formData = reactive({
  categoryId: "",
  name: "",
  description: "",
  type: "",
  code: "",
  extend: "",
  sort: "",
  title: "",
  content: "",
  author: ""
});

// const props = defineProps({
//   message: []
// });
// const categoryItems = ref(props.message);
// console.log("这里")
// console.log(props.message)

// const defaultProps = {
//   children: 'children',
//   label: 'name',
//   value: 'id',
//   isLeaf: 'leaf',
//   emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
// }
// 获取树形数据
// const categoryList = ref([])
// const getTree = async () => {
//   const res = await articleCategoryApi.getTreeApi({});
//   categoryList.value = res.data;
// };

//将这个方法暴露出去，供父组件调用
const categoryList = ref([]);
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
const onAddForm = async (categoryId: string) => {
  formData.categoryId = categoryId;
};

const onEditForm = async (id: string, categoryId: string) => {
  clearFrom();
  try {
    const res = await getShowApi(id);
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
    await getAddApi(formData);
  } else {
    await getEditApi(formData);
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
  //   {min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur"}
  // ],
  // title: [
  //   { required: true, message: "请输入标题", trigger: "blur" },
  //   { min: 3, max: 5, message: "长度在 3 到5 个字符", trigger: "blur" }
  // ]
});

//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
