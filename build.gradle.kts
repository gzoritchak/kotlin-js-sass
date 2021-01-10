plugins {
    kotlin("js").version("1.4.21")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(npm(projectDir.resolve("src/main/resources/css")))
    implementation(devNpm("node-sass", "^4.12.0"))
    implementation(devNpm("sass-loader", "^7.1.0"))
    implementation(devNpm("css-loader", "^4.2.0"))
    implementation(devNpm("style-loader","^1.2.0"))
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


