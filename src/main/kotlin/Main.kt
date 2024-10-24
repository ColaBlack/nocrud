import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import java.io.File
import java.io.OutputStreamWriter


fun main() {
    // 创建配置对象
    val config = Configuration(Configuration.VERSION_2_3_33)
    // 设置模板文件存放的目录
    config.setDirectoryForTemplateLoading(File("src/main/resources/templates"))
    // 设置默认的编码格式
    config.defaultEncoding = "UTF-8"
    // 设置异常处理器
    config.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
    /*
    利用HashMap创建数据模型
    {
    "user": "Big Joe",
    "latestProduct": {
        "url": "https://github.com/ColaBlack",
        "name": "No CRUD"
    }
     */
    val hashMap = HashMap<String, Any>()
    hashMap["user"] = "ColaBlack"
    val latest: MutableMap<String, Any> = HashMap()
    hashMap["latestProduct"] = latest
    latest["url"] = "https://github.com/ColaBlack"
    latest["name"] = "No CRUD"
    // 获取模板文件
    val template = config.getTemplate("demo.ftl")
    val out = OutputStreamWriter(File("src/main/java/edu/zafu/generated/demo.java").outputStream())
    // 输出渲染后的内容
    template.process(hashMap, out)
    // 关闭输出流
    out.close()
}