        plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
            kotlin("plugin.serialization").version("1.9.10").apply(false)
            id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin").version("2.0.1").apply(false)

}