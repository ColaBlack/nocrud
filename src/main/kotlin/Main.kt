import picocli.CommandLine
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("欢迎使用 NO CRUD")
    println("使用 -h 或者 --help 可以获得帮助信息")
    val argList = args.toMutableList()    // 将args转化为可变列表
    // 查询args中是否有参数a和h
    if (!args.contains("-a") && !args.contains("--author")) {
        // 如果没有参数a，则添加参数a
        argList.add("-a")
    }
    if (!args.contains("-p") && !args.contains("--package")) {
        argList.add("-p")
    }
    if (!args.contains("-n") && !args.contains("--name")) {
        argList.add("-n")
    }
    if (!args.contains("-k") && !args.contains("--key")) {
        argList.add("-k")
    }
    if (!args.contains("-u") && !args.contains("--upperKey")) {
        argList.add("-u")
    }
    if (!args.contains("-0") && !args.contains("--out")) {
        argList.add("-o")
    }

    val exitCode = CommandLine(CLI()).execute(*argList.toTypedArray())    // 执行命令
    exitProcess(exitCode)    // 退出程序
}