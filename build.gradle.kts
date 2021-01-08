plugins {
    kotlin("js").version("1.4.21")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(npm(projectDir.resolve("src/main/resources/css")))
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
        compilations["main"].packageJson {
            devDependencies["node-sass"] = "^4.12.0"
            devDependencies["sass-loader"] = "^7.1.0"
        }
        binaries.executable()
    }
}

tasks.register<Copy>("sass"){
    from("src/main/resources/css")
    into("build/js/node_modules/css")
}

tasks["processResources"].dependsOn(tasks["sass"])


