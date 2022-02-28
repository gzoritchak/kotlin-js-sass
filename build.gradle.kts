plugins {
    kotlin("js") version "1.6.10"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(npm(projectDir.resolve("src/main/resources/css")))
    implementation(devNpm("sass", "^1.49.9"))
    implementation(devNpm("sass-loader", "^12.6.0"))
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        binaries.executable()
    }
}

tasks.register<Copy>("sass"){
    from("src/main/resources/css")
    into("build/js/node_modules/css")
}

tasks["processResources"].dependsOn(tasks["sass"])


