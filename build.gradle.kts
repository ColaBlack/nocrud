import groovy.xml.dom.DOMCategory.attributes

plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.3"
    kotlin("jvm")
}

group = "edu.zafu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
    // https://mvnrepository.com/artifact/org.freemarker/freemarker
    implementation("org.freemarker:freemarker:2.3.33")
    // https://mvnrepository.com/artifact/info.picocli/picocli
    implementation("info.picocli:picocli:4.7.6")
//    implementation("com.gradleup.shadow:shadow-gradle-plugin:8.3.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}



tasks {
    shadowJar {
        archiveBaseName.set("nocrud")
        archiveVersion.set("")
        manifest {
            attributes["Main-Class"] = "cn.cola.nocrud.MainKt"
        }
    }
}