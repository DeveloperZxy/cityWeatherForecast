import { http } from "@/utils/http";

let urlPrefix = "/api/admin/systemSetting/configSetting";

//
export const getShowApi = () => {
  return http.request("post", `${urlPrefix}/show`);
};
//
export const getSaveApi = (data?: object) => {
  return http.request("post", `${urlPrefix}/save`, { data });
};
