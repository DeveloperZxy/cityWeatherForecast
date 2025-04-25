const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/SystemSetting",
  name: "SystemSetting",
  component: Layout,
  redirect: "/SystemSetting/SystemSettingInfo",
  meta: {
    icon: "ep:home-filled",
    title: "系统设置",
    rank: 0
  },
  children: [
    {
      path: "/SystemSetting/SystemSettingInfo",
      name: "SystemSettingInfo",
      component: () => import("@/views/systemSetting/systemSetting/index.vue"),
      meta: {
        title: "配置管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
    // {
    //   path: "/System/DictInfo",
    //   name: "DictInfo",
    //   component: () => import("@/views/system/dict/index.vue"),
    //   meta: {
    //     title: "字典管理",
    //     showLink: VITE_HIDE_HOME === "true" ? false : true
    //   }
    // },
    // {
    //   path: "/System/TplInfo",
    //   name: "TplInfo",
    //   component: () => import("@/views/system/sms/tpl/index.vue"),
    //   meta: {
    //     title: "短信管理",
    //     showLink: VITE_HIDE_HOME === "true" ? false : true
    //   }
    // },{
    //   path: "/System/PermissionInfo",
    //   name: "Permission",
    //   component: () => import("@/views/system/permission/index.vue"),
    //   meta: {
    //     title: "权限管理",
    //     showLink: VITE_HIDE_HOME === "true" ? false : true
    //   }
    // },
  ]
} satisfies RouteConfigsTable;
