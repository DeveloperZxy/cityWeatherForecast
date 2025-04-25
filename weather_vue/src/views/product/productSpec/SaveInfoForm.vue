<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <!--      <el-form-item label="分类" prop="categoryId" style="width: 650px">-->
      <!--        <el-tree-select-->
      <!--          v-model="formData.categoryId"-->
      <!--          :data="categoryList"-->
      <!--          check-strictly-->
      <!--          node-key="id"-->
      <!--          default-expand-all-->
      <!--          :props="defaultProps"-->

      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="标签名称" prop="name">
        <el-input v-model="formData.name" placeholder="请输入" />
      </el-form-item>
      <el-form-item label="排序值" prop="sort">
        <el-input-number v-model="formData.sort" :min="0" :max="10000" />
      </el-form-item>
      <el-form-item prop="status" label="是否开启" width="68">
        <el-switch
          v-model="formData.status"
          :active-value="1"
          :inactive-value="0"
          @change="
            () => {
              handleStatusChange(status);
            }
          "
        />
      </el-form-item>

      <!-- 动态生成属性输入区域 -->
      <el-form-item
        v-for="(rule, index) in formData.attrs"
        :key="index"
        :label="rule.name"
      >
        <el-tag
          v-for="(attr, attrIndex) in rule.attributes"
          :key="attrIndex"
          closable
          @close="removeAttribute(index, attrIndex)"
        >
          {{ attr }}
        </el-tag>
        <el-input
          v-model="newAttributes[index]"
          placeholder="请输入属性名称"
          @keyup.enter="addAttribute(index)"
        >
          <template #append>
            <el-button @click="addAttribute(index)">添加</el-button>
          </template>
        </el-input>
        <el-button type="danger" size="small" @click="removeRule(index)"
          >删除规则</el-button
        >
      </el-form-item>

      <!-- 添加新规则按钮 -->
      <el-button type="primary" @click="showAddRuleDialog"
        >添加新规则</el-button
      >
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button @click="getTree">刷新数据</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>

    <!-- 新规则名称输入对话框 -->
    <el-dialog v-model="addRuleDialogVisible" title="添加新规则" width="30%">
      <el-input v-model="newRuleName" placeholder="请输入新规则名称" />
      <template #footer>
        <el-button @click="addRuleDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="confirmAddRule">确定</el-button>
      </template>
    </el-dialog>
  </el-dialog>
</template>

<script lang="ts" setup>
import {
  getAddApi,
  getEditApi,
  getShowApi
} from "@/api/product/productSpec/productSpecInfoApi";

import { ref, reactive, defineExpose, onMounted } from "vue";
import { handleTree } from "@/utils/tree";
import * as productSpecInfoApi from "@/api/product/productSpec/productSpecInfoApi";
import { ElMessage, UploadProps } from "element-plus";

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
  sort: "",
  id: "",
  status: "",
  attrs: []
});

// const props = defineProps({
//   message: []
// });
// const categoryItems = ref(props.message);
// console.log("这里")
// console.log(props.message)
const defaultProps = {
  children: "children",
  label: "name",
  value: "id",
  isLeaf: "leaf",
  emitPath: false // 用于 cascader 组件：在选中节点改变时，是否返回由该节点所在的各级菜单的值所组成的数组，若设置 false，则只返回该节点的值
};

//改变状态status
const handleStatusChange = async (status: any) => {
  // 发起编辑状态
  if (status == 0) {
    let res = await productSpecInfoApi.getSetStatusApi({
      id: formData.id,
      status: 0
    });
  }
  if (status == 1) {
    let res = await productSpecInfoApi.getSetStatusApi({
      id: formData.id,
      status: 1
    });
  }
};
// 初始化newAttributes数组
const newAttributes = ref<string[]>([]);

const addRuleDialogVisible = ref(false);
const newRuleName = ref("");

const addAttribute = (ruleIndex: number) => {
  if (newAttributes.value[ruleIndex]?.trim()) {
    formData.attrs[ruleIndex].attributes.push(newAttributes.value[ruleIndex]);
    newAttributes.value[ruleIndex] = ""; // 清空对应的输入框
  }
};

const removeAttribute = (ruleIndex: number, attrIndex: number) => {
  formData.attrs[ruleIndex].attributes.splice(attrIndex, 1);
};

const removeRule = (ruleIndex: number) => {
  formData.attrs.splice(ruleIndex, 1);
  newAttributes.value.splice(ruleIndex, 1); // 同步更新newAttributes
};

const showAddRuleDialog = () => {
  addRuleDialogVisible.value = true;
};

const confirmAddRule = () => {
  if (newRuleName.value.trim()) {
    formData.attrs.push({ name: newRuleName.value, attributes: [] });
    newAttributes.value.push(""); // 同步更新newAttributes
    addRuleDialogVisible.value = false;
    newRuleName.value = "";
  } else {
    message.warning("规则名称不能为空");
  }
};

//将这个方法暴露出去，供父组件调用
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
  formData.attrs = [{ name: "颜色", attributes: ["红色", "蓝色"] }];
  newAttributes.value = new Array(formData.attrs.length).fill("");
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

onMounted(() => {});

//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
