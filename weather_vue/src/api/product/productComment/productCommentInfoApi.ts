import { http } from "@/utils/http";

let urlPrefix = "/api/admin/product/productComment";

//获取分页
export const getPageApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/page`, { data });
};

//增加
export const getAddApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/add`, { data });
};

//删除
export const getDelApi = (id: string) => {
  return http.request("post", `${urlPrefix}/del`, { data: { id } });
};

//编辑
export const getEditApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/edit`, { data });
};
//show
export const getShowApi = (id: string) => {
  return http.request("post", `${urlPrefix}/show`, { data: { id } });
};

//获取列表
export const getListApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/list`, { data });
};

//设置状态
export const getSetStatusApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/status`, { data });
};
//设置状态
export const getSetMobileShowApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/mobileShow`, { data });
};

//获取树
export const getTreeApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/tree`, { data });
};
