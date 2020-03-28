val kotlinVersion = "1.3.70"
val ktorGroup = "io.ktor"
val ktorVersion = "1.3.1"

plugins {
    java
    kotlin("jvm") version "1.3.70"
}

group = "ru.samganji.sambot"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    compile("org.telegram", "telegrambots", "4.6")

    compile(ktorGroup, "ktor-client-core", ktorVersion)
    compile(ktorGroup, "ktor-client-core-jvm", ktorVersion)
    compile(ktorGroup, "ktor-client-apache", ktorVersion)
    compile(ktorGroup, "ktor-gson", ktorVersion)
    compile(ktorGroup, "ktor-client-gson", ktorVersion)
    compile(ktorGroup, "ktor-client-json", ktorVersion)
    compile(ktorGroup, "ktor-client-json-jvm", ktorVersion)

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}