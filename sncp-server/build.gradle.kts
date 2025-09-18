plugins {
    java
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

var modules = arrayOf("sncp-base", "sncp-jdbc")

subprojects {
    if (project.name in modules) {
        apply(from = "${rootDir}/gradle/module-build.gradle.kts")
    }
}


