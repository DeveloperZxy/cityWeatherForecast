<template>
  <div>
    <MePageBasePanel>
      <template #main-top>
        <form>
          <el-input
            v-model="pageFilters.keyword"
            class="search-input"
            placeholder="请输入关键词"
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
        <el-table :data="pageList" style="width: 100%; min-height: 400px">
          <el-table-column type="index" label="序号" width="50" />
          <el-table-column prop="image" label="商品照片" width="80">
            <template #default="scope">
              <img :src="scope.row.image" alt="" style="" />
            </template>
          </el-table-column>

          <el-table-column prop="name" label="商品名称" width="130" />
          <el-table-column prop="username" label="用户名称" width="130" />
          <el-table-column prop="mark" label="评分" width="130" />
          <el-table-column prop="reviews" label="商品评价" width="130" />
          <el-table-column prop="quality" label="商品质量" width="130" />
          <el-table-column
            prop="serviceAttitude"
            label="服务态度"
            width="130"
          />
          <el-table-column
            prop="logisticsService"
            label="物流服务"
            width="130"
          />
          <el-table-column
            prop="evaluationContent"
            label="评价内容"
            width="130"
          />

          <!--        <el-table-column prop="status" label="状态" width="68">-->
          <!--          <template #default="scope">-->
          <!--            <el-switch-->
          <!--              v-model="scope.row.status"-->
          <!--              :active-value="1"-->
          <!--              :inactive-value="0"-->
          <!--              @change="-->
          <!--                () => {-->
          <!--                  handleStatusChange(scope.row)-->
          <!--                }-->
          <!--              "-->
          <!--            />-->
          <!--          </template>-->
          <!--        </el-table-column>-->

          <!--        <el-table-column prop="description" label="描述" width="130"/>-->
          <!--        <el-table-column prop="categoryId" label="类别"/>-->
          <!--        <el-table-column prop="code" label="编码"/>-->
          <!--            <el-table-column prop="sort" label="排序值"/>-->
          <!--            <el-table-column prop="createTime" label="创建时间"/>-->
          <el-table-column label="操作" width="230" fixed="right">
            <template #default="scope">
              <el-button
                link
                type="primary"
                @click="openForm('edit', scope.row.id, undefined)"
                >编辑
              </el-button>
              <el-button type="text">查看</el-button>
              <el-button type="text">回复</el-button>
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
    </MePageBasePanel>
    <SaveInfoForm
      ref="saveInfoFormRef"
      :message="categoryList"
      @success="onSuccessPageQuery"
    />
    <AdvancedQuery
      ref="advancedQueryRef"
      v-model="pageFilters"
      @success="onSuccessPageQuery"
      @resetForm="clearPageFilters"
    />
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted, reactive, watch } from "vue";
import * as productCommentInfoApi from "@/api/product/productComment/productCommentInfoApi";

import { Edit, Delete, Search, Plus } from "@element-plus/icons-vue";
import SaveInfoForm from "@/views/product/productComment/SaveInfoForm.vue";
import SaveCategory from "@/views/product/productComment/SaveCategory.vue";
import AdvancedQuery from "@/views/product/productComment/AdvancedQuery.vue";
import { ElMessage, ElMessageBox, ElTree } from "element-plus";
import MePageAsidePanel from "@/components/PageLayout/MePageAsidePanel.vue";
import { getSetMobileShowApi } from "@/api/product/productComment/productCommentInfoApi";
import MePageBasePanel from "@/components/PageLayout/MePageBasePanel.vue";

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
    let res = await productCommentInfoApi.getSetStatusApi({
      id: id,
      status: 0
    });
  }
  if (status == 1) {
    let res = await productCommentInfoApi.getSetStatusApi({
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

// //删除种类
// const onDelCategory = async (id: string) => {
//   //删除之前去认一下，弹出一个另一个框
//   ElMessageBox.confirm(
//     '你确定删除吗？',
//     '操作弹框',
//     {
//       confirmButtonText: '确认',
//       cancelButtonText: '取消',
//       type: 'warning',
//       // 其他可选配置项
//     }
//   ).then(async () => {
//     // 用户点击“确认”按钮时的回调
//     let res = await productCommentCategoryApi.getDelApi(id);
//     console.log(res);
//     if (res.success) {
//       ElMessage({
//         type: 'success',
//         message: '删除成功！'
//       });
//     } else {
//       ElMessage({
//         type: 'warning',
//         message: '该分类下还有子类，删除失败！'
//       });
//     }
//     refreshData();
//   }).catch(() => {
//     // 用户点击“取消”按钮或关闭对话框时的回调
//   });
//   // let res = await productCommentCategoryApi.getDelApi(id);
//   // console.log(res.success);
//   // refreshData();
// };

//数据更新
const refreshData = async () => {
  await getPage();
};

//展示种类列表
const handleShowCategoryItem = (data: any) => {
  pageFilters.categoryId = data.id;
  refreshData();
};

//获取分页
const getPage = async () => {
  const pageParams = {
    num: pageNum.value,
    size: pageSize.value,
    filters: pageFilters
  };
  const res = await productCommentInfoApi.getPageApi(pageParams);
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
const handleAddCategory = async (
  type: string,
  id?: string,
  categoryId?: string
) => {
  saveCategoryRef.value.open(type, id, categoryId);
  refreshData();
};

//删除方法
const handleDelete = async (id: string) => {
  //删除之前去认一下，弹出一个另一个框
  ElMessageBox.confirm("你确定删除吗？", "操作弹框", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning"
    // 其他可选配置项
  })
    .then(async () => {
      // 用户点击“确认”按钮时的回调
      let res = await productCommentInfoApi.getDelApi(id);
      console.log(res.success);
      if (res.success) {
        refreshData();
        ElMessage({
          type: "success",
          message: "删除成功！"
        });
      } else {
        ElMessage({
          type: "warning",
          message: "删除失败！"
        });
      }
    })
    .catch(() => {
      // 用户点击“取消”按钮或关闭对话框时的回调
    });
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
.page-wapper {
  margin: 8px;
  //border: 1px solid red;
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  height: calc(100vh - 160px);

  .page-aside {
    min-width: 140px;
    max-width: 220px;
    box-sizing: border-box;
    background-color: #fff;
    border-radius: 10px;
    margin-right: 10px;
    padding: 10px;

    .tree-keyword {
      display: flex;
      align-items: center;
      margin-bottom: 20px; /* 添加与下方目录的间距 */
    }

    .search-input {
      flex: 1;
      width: 150px;
    }

    .search-button,
    .add-button {
      margin-left: 0px; /* 按钮之间的间距 */
    }

    //目录
    .tree-node-content {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 0 10px; /* 添加内边距 */
      transition: background-color 0.3s; /* 平滑过渡效果 */
    }

    .tree-node-content span {
      flex: 1;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    .tree-node-content .el-icon {
      margin-left: 10px; /* 图标之间的间距 */
      cursor: pointer;
      color: #909399;
      font-size: 16px;
    }

    .tree-node-content .el-icon:hover {
      color: #409eff;
    }

    .tree-node-content:hover {
      background-color: #f5f7fa;
    }

    .tree-node-content:active {
      background-color: #e9eef3;
    }
  }

  .page-body {
    flex: 1;

    display: flex;
    flex-direction: column;

    .page-header {
      //border: 1px solid red;

      background-color: #fff;
      border-radius: 10px;
      padding: 10px;

      margin-bottom: 10px;
    }

    .page-content {
      flex: 1;
      //border: 1px solid red;

      background-color: #fff;
      border-radius: 10px;

      padding: 10px;
    }
  }
}
</style>
