import picocli.CommandLine
import picocli.CommandLine.*
import java.io.File

@Command(
    name = "ls",
    mixinStandardHelpOptions = true,
    version = ["ls 1.0"],
    description = ["Lists the contents of a directory."]
)
class LsCommand : Runnable {
    @Option(names = ["-a", "--all"], description = ["do not ignore entries starting with ."])
    var showAll: Boolean = false

    @Parameters(index = "0", description = ["the directory to list"])
    var directory: String? = null

    override fun run() {
        if (directory == null) {
            println("No directory specified")
            return
        }
        val file = File(directory)
        if (!file.exists()) {     // 判断目录是否存在
            println("Directory not found: $directory")
            return
        }
        if (!file.isDirectory) {  // 判断是否为目录
            println("$directory is not a directory")
            return
        }
        val files = file.listFiles()
        if (files == null) {       // 判断目录是否为空
            println("Directory is empty")
            return
        }
        for (file in files) {
            if (showAll || !file.name.startsWith(".")) {
                println(file.name)
            }
        }
    }
}

fun main(args: Array<String>) {
    val cmd = CommandLine(LsCommand())
    cmd.execute(*args)
}