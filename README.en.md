# cityWeatherForecast

#### Description
This is a city weather forecast management system based on Spring Boot and Vue3. The project adopts a front-end and back-end separation architecture. The front-end is developed based on the `pure-admin-thin` template, and the back-end uses the Spring Boot family bucket to implement functions such as user authentication, weather data management, and visual display.

#### Tech Stack

**Backend**
- **Core Framework:** Spring Boot 2.6.13
- **Database/ORM:** MySQL 8.0, MyBatis-Plus 3.5.4
- **Authentication:** JJWT (JSON Web Tokens)
- **Utility Libraries:** Lombok, Hutool, FastJSON

**Frontend**
- **Core Framework:** Vue 3
- **Build Tool:** Vite
- **UI Framework:** Element Plus
- **CSS Solution:** Tailwind CSS
- **State Management:** Pinia
- **Charting Library:** ECharts
- **Language:** TypeScript

#### Directory Structure
```
.
├── weather         # Backend Spring Boot project
├── weather_vue     # Frontend Vue3 project
└── weather.sql     # Database initialization script
```

#### Installation and Setup

**1. Prerequisites**
- JDK >= 11
- Maven >= 3.5
- MySQL >= 8.0
- Node.js >= 18.0
- pnpm >= 9.0

**2. Backend Setup**
- Clone the project locally.
- Use a MySQL client to create a database and import the `weather.sql` file from the root directory.
- Open `weather/src/main/resources/application.yml` and modify the database connection settings.
- In the `weather` directory, run `mvn clean install` to build the project.
- Run the Spring Boot application by starting the `PracticeProjectApplication` class.

**3. Frontend Setup**
- Navigate to the `weather_vue` directory.
- Run `pnpm install` to install dependencies.
- Run `pnpm dev` to start the project.
- Open your browser and go to `http://localhost:5173` (or the port specified by Vite).

#### Contribution

1.  Fork the repository
2.  Create a new branch (`git checkout -b feat/xxxx`)
3.  Commit your changes
4.  Create a Pull Request

#### Gitee Feature

1.  You can use Readme\_XXX.md to support different languages, such as Readme\_en.md, Readme\_zh.md
2.  Gitee blog [blog.gitee.com](https://blog.gitee.com)
3.  Explore open source project [https://gitee.com/explore](https://gitee.com/explore)
4.  The most valuable open source project [GVP](https://gitee.com/gvp)
5.  The manual of Gitee [https://gitee.com/help](https://gitee.com/help)
6.  The most popular members  [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
