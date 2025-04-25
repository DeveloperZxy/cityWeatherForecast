const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/System",
  name: "System",
  component: Layout,
  redirect: "/System/ConfigInfo",
  meta: {
    icon: "ep:home-filled",
    title: "系统模块",
    rank: 0
  },
  children: [
    {
      path: "/System/ConfigInfo",
      name: "ConfigInfo",
      component: () => import("@/views/system/config/index.vue"),
      meta: {
        title: "配置管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/System/DictInfo",
      name: "DictInfo",
      component: () => import("@/views/system/dict/index.vue"),
      meta: {
        title: "字典管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/System/TplInfo",
      name: "TplInfo",
      component: () => import("@/views/system/sms/tpl/index.vue"),
      meta: {
        title: "短信管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/System/PermissionInfo",
      name: "PermissionInfo",
      component: () => import("@/views/system/permission/index.vue"),
      meta: {
        title: "权限管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/System/RolesInfo",
      name: "RolesInfo",
      component: () => import("@/views/system/role/index.vue"),
      meta: {
        title: "角色管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
  ]
} satisfies RouteConfigsTable;
