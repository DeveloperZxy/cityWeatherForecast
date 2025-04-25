import { http } from "@/utils/http";

type Result = {
  success: boolean;
  data: Array<any>;
};

export const getAsyncRoutes = (data?: object) => {
  // return http.request<Result>("get", "/get-async-routes");
  return http.request<Result>("post", "/api/admin/users//getPermissions", {
    data
  });
};
