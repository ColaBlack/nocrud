import picocli.CommandLine
import picocli.CommandLine.*
import java.io.File
import kotlin.system.exitProcess

/**
 * ls命令demo
 *
 * @author ColaBlack
 */
// 定义一个dir命令，name为ls，description为该命令的描述信息，mixinStandardHelpOptions为true，表示该命令需要自动生成help选项
@Command(name = "dir", description = ["列出当前目录的目录结构"], mixinStandardHelpOptions = true)
// 定义一个dir类，继承Runnable接口，实现run方法，用于执行ls命令，其中Callable的泛型int表示call方法的返回值类型
class Dir : Runnable {

    // 该参数在命令行中指定，索引为0，description为描述信息
    @Parameters(index = "0", description = ["要列出的目录路径"])
    var path: String? = null // 定义一个path变量，用于接收命令行参数

    // 该选项缩写为-a，全称为--all，description为描述信息
    @Option(names = ["-a", "--all"], description = ["显示所有文件，包括隐藏文件"])
    var showHidden = false // 定义一个showHidden变量，用于接收-a选项，是否显示隐藏文件

    // 用户执行命令时，会调用run方法
    override fun run() {
        if (path == null) {
            println("文件路径不能为空")
            return
        }
        val file = File(path!!)
        if (!file.exists()) {     // 判断目录是否存在
            println("文件路径不存在: $path")
            return
        }
        if (!file.isDirectory) {  // 判断是否为目录
            println("$path 不是一个目录")
            return
        }
        val files = file.listFiles()
        if (files == null) {       // 判断目录是否为空
            println("目录为空")
            return
        }
        for (item in files) {
            if (showHidden || !item.name.startsWith(".")) {
                println(item.name)
            }
        }
    }
}

fun main(args: Array<String>) {
    val exitCode = CommandLine(Dir()).execute(*args)    // 执行命令
    exitProcess(exitCode)    // 退出程序
}