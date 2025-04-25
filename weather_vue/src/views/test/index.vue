<template>
  <div>
    <MePageAsidePanel>
      <template #aside>
        <!-- 左侧树-->
        <div>
          <div class="head-container">
            <div class="tree-keyword">
              <el-input
                v-model="categoryName"
                class="search-input"
                clearable
                placeholder="请输入关键词"
              />
              <el-button
                plain
                :icon="Search"
                class="search-button"
                @click="getTree"
              />
              <el-button
                plain
                :icon="Plus"
                class="add-button"
                @click="handleAddCategory('add', null)"
              />
            </div>
          </div>
          <div class="head-container" style="overflow-y: auto">
            <!--        将左侧目录categoryList一级目录展示出来-->
            <el-tree
              :data="categoryList"
              node-key="id"
              default-expand-all
              @node-click="handleShowCategoryItem"
            >
              <template #default="{ node, data }">
                <div class="tree-node-content">
                  <span>{{ data.name }}</span>
                  <el-icon @click="handleAddCategory('edit', data.id)">
                    <Edit />
                  </el-icon>
                  <el-icon @click="onDelCategory(data.id)">
                    <Delete />
                  </el-icon>
                </div>
              </template>
            </el-tree>
          </div>

          <!-- 添加或修改用户对话框 -->
          <SaveCategoryForm ref="formRef" @success="getTree" />
        </div>
      </template>
      <template #main-top>
        <form>
          <el-input
            v-model="pageFilters.keyword"
            class="search-input"
            placeholder="请输入关键词/标题/内容/作者"
            style="width: 250px"
            clearable
          />
          <el-button type="primary" @click="getPage">查询</el-button>
          <el-button type="primary" @click="onAdvancedQuery"
            >高级查询</el-button
          >

          <!-- 新增 -->
          <el-button
            type="primary"
            plain
            @click="openForm('add', undefined, pageFilters.categoryId)"
            >新增
          </el-button>
        </form>
      </template>
      <template #main-content>
        <el-table :data="pageList" style="width: 100%">
          <el-table-column type="index" label="序号" width="180" />
          <el-table-column prop="title" label="标题" width="180" />
          <el-table-column prop="content" label="内容" />
          <el-table-column prop="author" label="作者" />
          <el-table-column prop="status" label="状态" width="68">
            <template #default="scope">
              <el-switch
                v-model="scope.row.status"
                :active-value="1"
                :inactive-value="0"
                @change="
                  () => {
                    handleStatusChange(scope.row);
                  }
                "
              />
            </template>
          </el-table-column>
          <el-table-column prop="createdTime" label="创建时间" />
          <el-table-column label="操作" width="160" fixed="right">
            <template #default="scope">
              <el-button
                link
                type="primary"
                @click="openForm('edit', scope.row.id, undefined)"
                >编辑
              </el-button>
              <el-button link type="danger" @click="handleDelete(scope.row.id)"
                >删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <el-pagination
          v-model:current-page="pageNum"
          v-model:page-size="pageSize"
          :total="pageTotal"
          :page-sizes="[1, 5, 10, 20]"
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </template>
    </MePageAsidePanel>

    <SaveInfoForm
      ref="saveInfoFormRef"
      :message="categoryList"
      @success="onSuccessPageQuery"
    />
    <SaveCategory ref="saveCategoryRef" @success="onSuccessPageQuery" />
    <AdvancedQuery
      ref="advancedQueryRef"
      v-model="pageFilters"
      @success="onSuccessPageQuery"
      @resetForm="clearPageFilters"
    />
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted, reactive } from "vue";
import * as demoInfoApi from "@/api/demo/demoInfoApi";
import * as demoCategoryApi from "@/api/demo/demoCategoryApi";
import SaveInfoForm from "@/views/home/SaveInfoForm.vue";
import { Edit, Delete, Search, Plus } from "@element-plus/icons-vue";
import SaveCategory from "@/views/home/SaveCategory.vue";
import AdvancedQuery from "@/views/home/AdvancedQuery.vue";

let treeData = {
  name: "TplInfo",
  path: "/System/TplInfo",
  component: "@/views/system/sms/tpl/index.vue",
  title: "短信管理"
};

let abc = {
  path: treeData.name,
  name: "TplInfo",
  component: () => import(treeData.component),
  meta: {
    title: treeData.title,
    showLink: ""
  }
};

const categoryName = ref("");
const categoryList = ref([]);

const pageNum = ref(1);
const pageSize = ref(10);
const pageTotal = ref();
const pageList = ref([]);

const pageFiltersDefault = ref({
  categoryId: undefined,
  keyword: undefined,
  createdTime: [],
  name: "",
  code: "",
  status: ""
});

const pageFilters = reactive({
  ...pageFiltersDefault.value
});

//改变状态status
const handleStatusChange = async (row: any) => {
  const { id, status } = row;
  // 发起编辑状态
  if (status == 0) {
    let res = await demoInfoApi.getSetStatusApi({
      id: id,
      status: 0
    });
  }
  if (status == 1) {
    let res = await demoInfoApi.getSetStatusApi({
      id: id,
      status: 1
    });
  }
};

// 处理页码变化
const handleCurrentChange = (newPage: number) => {
  pageNum.value = newPage;
  refreshData();
};

// 处理每页显示条数变化
const handleSizeChange = (newSize: number) => {
  pageSize.value = newSize;
  refreshData();
};

//清空表单pageFilters、
const clearPageFilters = () => {
  Object.keys(pageFiltersDefault.value).forEach(key => {
    pageFilters[key] = pageFiltersDefault.value[key];
  });
  console.log(pageFilters);
};

//删除种类
const onDelCategory = async (id: string) => {
  //需要校验
  await demoCategoryApi.getDelApi(id);
};

//数据更新
const refreshData = async () => {
  await getTree();
  await getPage();
};

//展示种类列表
const handleShowCategoryItem = (data: any) => {
  pageFilters.categoryId = data.id;
  refreshData();
};
// const handleShowCategoryItem = (data: any) => {
//   console.log(data.id)
// }

// 获取树形数据
const getTree = async () => {
  const pageParams = {
    filters: {
      name: categoryName.value
    }
  };
  const res = await demoCategoryApi.getTreeApi(pageParams);
  categoryList.value = res.data;
};

//获取分页
const getPage = async () => {
  const pageParams = {
    num: pageNum.value,
    size: pageSize.value,
    filters: pageFilters
  };
  const res = await demoInfoApi.getPageApi(pageParams);
  pageList.value = res.data.list;
  pageTotal.value = parseInt(res.data.total);
  pageNum.value = parseInt(res.data.num);
  pageSize.value = parseInt(res.data.size);
};

//高级查询
const advancedQueryRef = ref();
const onAdvancedQuery = () => {
  advancedQueryRef.value.open();
};

//增加种类的方法
const saveCategoryRef = ref();
const handleAddCategory = async (type: string, id?: string) => {
  saveCategoryRef.value.open(type, id);
  refreshData();
};

//删除方法
const handleDelete = async (id: string) => {
  // 发起删除
  await demoInfoApi.getDelApi(id);
  // 刷新列表
  refreshData();
};

//新增、编辑页面
const saveInfoFormRef = ref();
const openForm = (type: string, id?: any, categoryId?: any) => {
  saveInfoFormRef.value.open(type, id, categoryId);
  refreshData();
};

//子调父成功方法
const onSuccessPageQuery = () => {
  refreshData();
  console.log("子调父成功方法");
};

onMounted(() => {
  refreshData();
});
</script>

<style lang="scss" scoped>
.tree-keyword {
  display: flex;
  align-items: center; /* 垂直居中对齐 */
  gap: 0; /* 移除元素之间的间距 */
}

.search-input {
  flex: 1; /* 输入框占据剩余空间 */
  width: 150px; /* 固定宽度 */
  margin-right: 0; /* 移除右侧外边距 */
}

.search-button,
.add-button {
  margin-left: 0; /* 移除左侧外边距 */
}
</style>
