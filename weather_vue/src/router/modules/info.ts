const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/",
  name: "InfoBase",
  component: Layout,
  redirect: "/InfoBase/AdminInfo",
  meta: {
    icon: "ep:home-filled",
    title: "基础管理",
    rank: 0
  },
  children: [
    {
      path: "/InfoBase/AdminInfo",
      name: "AdminInfo",
      component: () => import("@/views/info/admin/index.vue"),
      meta: {
        title: "员工标签",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
  ]
} satisfies RouteConfigsTable;
