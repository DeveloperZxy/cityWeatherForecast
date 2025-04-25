const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/User",
  name: "User",
  component: Layout,
  redirect: "/User/UserInfo",
  meta: {
    icon: "ep:home-filled",
    title: "用户管理",
    rank: 0
  },
  children: [
    {
      path: "/User/UserInfo",
      name: "UserInfo",
      component: () => import("@/views/crm/user/index.vue"),
      meta: {
        title: "用户管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/User/UserCenter",
      name: "UserCenter",
      component: () => import("@/views/crm/user/UserCenter.vue"),
      meta: {
        title: "用户中心",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
    // {
    //   path: "/User/UserTag",
    //   name: "UserTag",
    //   component: () => import("@/views/crm/userTag/index.vue"),
    //   meta: {
    //     title: "用户标签",
    //     showLink: VITE_HIDE_HOME === "true" ? false : true
    //   }
    // }
  ]
} satisfies RouteConfigsTable;
