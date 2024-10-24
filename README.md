# NO CRUD

no crud是基于springModel的辅助工具，它可以帮助你快速生成一个带有基础增删改查功能的后端controller层代码。

### 如何使用

从release页面下载最新版本的no-crud.jar，然后在命令行中执行以下命令：

```bash
java -jar no-crud.jar
```

然后根据提示输入包名、作者等信息，即可生成一个带有基础增删改查功能的后端controller层代码。

```bash
java -jar no-crud.jar -h
```

可以获得帮助信息。

### 注意事项

- 由于各操作系统的文件系统的差异且本人只在Windows上进行了测试，所以不保证该工具在其他系统上是否可用。
- 如果确需使用，可以将代码在Windows开发环境中运行，然后将生成的代码拷贝到其他环境中。
- 生成的代码中有部分TODO注释，可以根据需要进行修改。
- 该工具的ORM框架为mybatis 和 mybatis-plus，如果需要使用其他ORM框架，请自行修改代码。

### 技术栈

- 模版引擎FreeMarker
- 命令行制作器Picocli
- kotlin语言

### 运行样例

![运行样例](https://2f7171c5.cloudflare-imgbed-bo7.pages.dev/file/1729774833154_Snipaste_2024-10-24_20-59-27.png)

### 项目地址

- [no-crud-github](https://github.com/ColaBlack/nocrud)
- [no-crud-gitee](https://gitee.com/ColaBlack/nocrud)

### 友情项目

gitee 仓库地址：
- [SpringModel](https://gitee.com/colablack/spring-model)
- [VueModel](https://gitee.com/colablack/vue-model)
- [teaai-backend](https://gitee.com/colablack/teaai-backend)
- [teaai-frontend](https://gitee.com/colablack/teaai-frontend)

github 仓库地址：
- [SpringModel](https://github.com/ColaBlack/spring-model)
- [VueModel](https://github.com/ColaBlack/vue-model)
- [teaai-backend](https://github.com/ColaBlack/tea_ai_backend)
- [teaai-frontend](https://github.com/ColaBlack/teaai-frontend)

说明：springModel，vueModel是从teaai前后端两个项目中抽离了部分核心代码简化得来，而本项目则是帮助大家使用springModel的辅助工具。