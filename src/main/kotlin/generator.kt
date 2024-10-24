import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import java.io.File
import java.io.OutputStreamWriter

fun generator(model: HashMap<String, String>, input: String, output: String, upperKey: String) {
    // 创建配置对象
    val config = Configuration(Configuration.VERSION_2_3_33)
    // 设置模板文件存放的目录
    config.setDirectoryForTemplateLoading(File("src/main/resources/templates"))
    // 设置默认的编码格式
    config.defaultEncoding = "UTF-8"
    // 设置异常处理器
    config.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
    // 获取模板文件
    val template = config.getTemplate(input)
    var file = File(output)
    //获取文件绝对路径
    file = file.absoluteFile
    if (!file.exists()) {
        if (file.isDirectory) {
            file.mkdirs()
            file = File(file, "${upperKey}Controller.java")
        } else {
            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs()
            }
            file.createNewFile()
        }
    } else {
        if (file.isDirectory) {
            file = File(file, "${upperKey}Controller.java")
        }
    }

    val out = OutputStreamWriter(file.outputStream())
    // 输出渲染后的内容
    template.process(model, out)
    // 关闭输出流
    out.close()
}