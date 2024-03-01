import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)

        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation("media.kamel:kamel-image:0.9.1")
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.coroutines.core)
            api(compose.foundation)
            api(compose.animation)
            val precomposeVersion = "1.5.10"
            api("moe.tlaster:precompose:$precomposeVersion")
            api("moe.tlaster:precompose-molecule:$precomposeVersion")
            api("moe.tlaster:precompose-viewmodel:$precomposeVersion")
            api("moe.tlaster:precompose-koin:$precomposeVersion")
            implementation("com.darkrockstudios:mpfilepicker:3.1.0")

            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:32.7.0"))

            implementation("dev.gitlive:firebase-firestore:1.11.0")
            implementation("dev.gitlive:firebase-storage:1.11.0")
            implementation("dev.gitlive:firebase-common:1.11.0")
            implementation("dev.gitlive:firebase-app:1.11.0")
            implementation("dev.gitlive:firebase-installations:1.11.0")
            implementation("com.google.firebase:firebase-storage")
        }
    }
}

android {
    namespace = "org.purchaser.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.purchaser.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
dependencies {
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")


}
