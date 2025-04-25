const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/Article",
  name: "Article",
  component: Layout,
  redirect: "/Article/ArticleInfo",
  meta: {
    icon: "ep:home-filled",
    title: "文章管理",
    rank: 0
  },
  children: [
    {
      path: "/Article/ArticleInfo",
      name: "ArticleInfo",
      component: () => import("@/views/cms/article/index.vue"),
      meta: {
        title: "文章管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Article/ArticleTag",
      name: "ArticleTag",
      component: () => import("@/views/cms/articleTag/index.vue"),
      meta: {
        title: "文章标签",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Article/TestMe",
      name: "TestMe",
      component: () => import("@/views/test/test.vue"),
      meta: {
        title: "测试页面",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
  ]
} satisfies RouteConfigsTable;
