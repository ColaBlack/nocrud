package cn.cola.nocrud

import picocli.CommandLine.Command
import picocli.CommandLine.Option

/**
 * NO CRUD CLI代码
 *
 * @author ColaBlack
 */
@Command(name = "no-crud", version = ["1.0"], mixinStandardHelpOptions = true)
class CLI : Runnable {

    @Option(
        names = ["-p", "--package"],
        description = ["生成的包名"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var packageName = ""

    @Option(
        names = ["-k", "--key"],
        description = ["要生成的对象的英文名（小驼峰）"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var key = ""

    @Option(
        names = ["-u", "--upper-key"],
        description = ["要生成的对象的英文名（大驼峰）"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var upperKey = ""

    @Option(
        names = ["-n", "--name"],
        description = ["生成的中文对象名"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var name = ""

    @Option(
        names = ["-a", "--author"],
        description = ["作者"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var author = ""

    @Option(
        names = ["-o", "--out"],
        description = ["要生成的路径"],
        arity = "0..1",
        interactive = true,
        echo = true
    )
    var outPath = ""

    override fun run() {
        println("正在生成controller代码...")
        val model = getModel(packageName, key, upperKey, name, author)
        generator(model, "controller.ftl", outPath,upperKey)
        println("生成完毕")
    }

}