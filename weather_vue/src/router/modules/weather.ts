const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/Weather",
  name: "Weather",
  component: Layout,
  redirect: "/Weather/WeatherInfo",
  meta: {
    icon: "ep:home-filled",
    title: "天气管理",
    rank: 0
  },
  children: [
    {
      path: "/Weather/WeatherInfo",
      name: "WeatherInfo",
      component: () => import("@/views/weather/WeatherIndex.vue"),
      meta: {
        title: "天气管理",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Weather/WeatherDetail",
      name: "WeatherDetail",
      component: () => import("@/views/weather/detail/WeatherDetail.vue"),
      meta: {
        title: "天气详情",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Weather/Test",
      name: "WeatherTest",
      component: () => import("@/views/weather/Test.vue"),
      meta: {
        title: "测试",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },

  ]
} satisfies RouteConfigsTable;
