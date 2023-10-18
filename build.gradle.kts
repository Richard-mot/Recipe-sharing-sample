plugins {
    kotlin("jvm") version "1.5.30"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-netty:1.6.4")
    implementation("io.ktor:ktor-jackson:1.6.4")
}
