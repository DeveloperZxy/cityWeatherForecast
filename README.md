# cityWeatherForecast

#### 介绍
这是一个基于 Spring Boot 和 Vue3 的城市天气预报管理系统。项目采用前后端分离的架构，前端基于 `pure-admin-thin` 模板进行开发，后端采用 Spring Boot 全家桶，实现了用户认证、天气数据管理和可视化展示等功能。

#### 技术栈

**后端 (Backend)**
- **核心框架:** Spring Boot 2.6.13
- **数据库/ORM:** MySQL 8.0, MyBatis-Plus 3.5.4
- **认证授权:** JJWT (JSON Web Tokens)
- **工具库:** Lombok, Hutool, FastJSON

**前端 (Frontend)**
- **核心框架:** Vue 3
- **构建工具:** Vite
- **UI 框架:** Element Plus
- **CSS 方案:** Tailwind CSS
- **状态管理:** Pinia
- **图表库:** ECharts
- **编程语言:** TypeScript

#### 目录结构
```
.
├── weather         # 后端 Spring Boot 项目
├── weather_vue     # 前端 Vue3 项目
└── weather.sql     # 数据库初始化脚本
```

#### 安装和运行

**1. 环境准备**
- JDK >= 11
- Maven >= 3.5
- MySQL >= 8.0
- Node.js >= 18.0
- pnpm >= 9.0

**2. 后端启动**
- 将项目克隆到本地。
- 使用 MySQL 客户端，创建数据库并导入根目录下的 `weather.sql` 文件。
- 打开 `weather/src/main/resources/application.yml` 文件，修改数据库的连接配置。
- 在 `weather` 目录下，执行 `mvn clean install` 来构建项目。
- 运行 Spring Boot 启动类 `PracticeProjectApplication`。

**3. 前端启动**
- 进入 `weather_vue` 目录。
- 执行 `pnpm install` 安装依赖。
- 执行 `pnpm dev` 启动项目。
- 在浏览器中访问 `http://localhost:5173` (或其他 Vite 启动时指定的端口)。

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
