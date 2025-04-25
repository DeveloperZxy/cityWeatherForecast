const { VITE_HIDE_HOME } = import.meta.env;
const Layout = () => import("@/layout/index.vue");

export default {
  path: "/Product",
  name: "Product",
  component: Layout,
  redirect: "/Product/ProductTag",
  meta: {
    icon: "ep:home-filled",
    title: "商品管理",
    rank: 0
  },
  children: [
    {
      path: "/Product/ProductTag",
      name: "ProductTag",
      component: () => import("@/views/product/productTag/index.vue"),
      meta: {
        title: "商品标签",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Product/ProductBrand",
      name: "ProductBrand",
      component: () => import("@/views/product/productBrand/index.vue"),
      meta: {
        title: "商品品牌",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Product/ProductCategory",
      name: "ProductCategory",
      component: () => import("@/views/product/productCategory/index.vue"),
      meta: {
        title: "商品分类",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Product/ProductSpec",
      name: "ProductSpec",
      component: () => import("@/views/product/productSpec/index.vue"),
      meta: {
        title: "商品规格",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    },
    {
      path: "/Product/ProductComment",
      name: "ProductComment",
      component: () => import("@/views/product/productComment/index.vue"),
      meta: {
        title: "商品评论",
        showLink: VITE_HIDE_HOME === "true" ? false : true
      }
    }
  ]
} satisfies RouteConfigsTable;
