<template>
  <el-dialog v-model="dialogShow" :title="title">
    <el-form :ref="formRef" :model="formData" :rules="rules" label-width="80px">
      <el-form-item label="分类" prop="categoryId" style="width: 650px">
        <el-tree-select
          v-model="formData.categoryId"
          :data="categoryList"
          check-strictly
          node-key="id"
          default-expand-all
          :props="defaultProps"
        />
      </el-form-item>
      <el-form-item label="用户角色" prop="roles">
        <RoleSelect v-model="formData.roles" />
      </el-form-item>
      <el-form-item label="用户角色" prop="username">
        <el-input v-model="formData.username" />
      </el-form-item>
      <el-form-item label="用户编号" prop="code">
        <el-input v-model="formData.code" />
      </el-form-item>
      <el-form-item label="真实姓名" prop="name">
        <el-input v-model="formData.name" />
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
        <el-input v-model="formData.phone" />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker
          v-model="formData.birthday"
          type="date"
          placeholder="请选择生日"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idNumber">
        <el-input v-model="formData.idNumber" />
      </el-form-item>
      <el-form-item label="用户地址" prop="address">
        <el-input v-model="formData.address" />
      </el-form-item>
      <el-form-item label="描述" prop="remark">
        <el-input
          v-model="formData.remark"
          :rows="2"
          type="textarea"
          placeholder="请输入"
        />
      </el-form-item>

      <el-form-item label="登录密码" prop="password">
        <el-input v-model="formData.password" type="password" />
      </el-form-item>
      <!--      <el-form-item label="确认密码" prop="confirmPassword">-->
      <!--        <el-input v-model="formData.confirmPassword" type="password"></el-input>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="用户等级" prop="userGrade">-->
      <!--        <el-select v-model="formData.userGrade" placeholder="请选择用户等级">-->
      <!--          <el-option label="普通用户" value="normal"></el-option>-->
      <!--          <el-option label="VIP用户" value="vip"></el-option>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="用户分组" prop="userGroup">-->
      <!--        <el-select v-model="formData.userGroup" placeholder="请选择用户分组">-->
      <!--          <el-option label="分组1" value="group1"></el-option>-->
      <!--          <el-option label="分组2" value="group2"></el-option>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="用户标签" prop="userTag">-->
      <!--        <el-select v-model="formData.userTag" placeholder="请选择用户标签">-->
      <!--          <el-option label="标签1" value="tag1"></el-option>-->
      <!--          <el-option label="标签2" value="tag2"></el-option>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <el-form-item prop="status" label="状态" width="68">
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
      <!--      <el-form-item label="推广资格" prop="categoryId">-->
      <!--        <el-radio-group v-model="formData.promotion">-->
      <!--          <el-radio label="启用">启用</el-radio>-->
      <!--          <el-radio label="禁用">禁用</el-radio>-->
      <!--        </el-radio-group>-->
      <!--      </el-form-item>-->
    </el-form>
    <template #footer>
      <el-button @click="handleFormCancle">取 消</el-button>
      <el-button @click="getTree">刷新数据</el-button>
      <el-button type="primary" @click="handleFormSubmit">确 定</el-button>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import { getAddApi, getEditApi, getShowApi } from "@/api/crm/user/userInfoApi";
import * as tplCategoryApi from "@/api/crm/user/userCategoryApi";

import { ref, reactive, defineExpose, onMounted } from "vue";
import { handleTree } from "@/utils/tree";
import * as tplInfoApi from "@/api/system/sms/tpl/tplInfoApi";
import RoleSelect from "@/components/Me/RoleSelect.vue";

const emit = defineEmits(["success"]);

const title = ref("");
const dialogShow = ref(false);
const formRef = ref();

const formData = reactive({
  categoryId: "",
  name: "",
  description: "",
  code: "",
  status: "",
  sort: "",
  remark: "",
  phone: "",
  password: "",
  confirmPassword: "",
  birthday: "",
  idNumber: "",
  address: "",
  userGrade: "",
  userGroup: "",
  userTag: "",
  promotion: "",
  roles: [],
  username: "",
  id: "",
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
const handleStatusChange = async status => {
  // 发起编辑状态
  if (status == 0) {
    let res = await tplInfoApi.getSetStatusApi({
      id: formData.id,
      status: 0
    });
  }
  if (status == 1) {
    let res = await tplInfoApi.getSetStatusApi({
      id: formData.id,
      status: 1
    });
  }
};

// 获取树形数据
const categoryList = ref([]);
const getTree = async () => {
  const res = await tplCategoryApi.getTreeApi({});
  categoryList.value = res.data;
};

//将这个方法暴露出去，供父组件调用
const open = async (type: string, id?: any, categoryId?: any) => {
  //获取树形数据(前端处理树)    0为不包含Root ，1为包含Root（前后端约定的）
  let response = await tplCategoryApi.getListApi({ includeRoot: "0" });
  const treeDataTemp = response.data;
  //这里是前端手动加上全部
  // treeDataTemp.push({
  //   id: '0',
  //   name: '全部',
  //   parentId: '-1',
  //   sort: 0,
  //   status: 0,
  //   createTime: 1717050623000,
  // })
  categoryList.value = handleTree(treeDataTemp);

  console.log("treeDataTempe", treeDataTemp.value);
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

getTree();
//向外暴露open方法
defineExpose({
  open
});
</script>

<style lang="scss" scoped></style>
