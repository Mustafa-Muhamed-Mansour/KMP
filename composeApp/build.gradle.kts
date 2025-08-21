@file:OptIn(ExperimentalComposeLibrary::class)

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // Ktor to get data from network (api)
            implementation(libs.ktor.client.android)
            implementation(libs.ktor.client.okhttp)

            // -----> Start a lifecycle <----- //
            // ViewModel
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            // Lifecycles only (without ViewModel or LiveData)
            implementation(libs.androidx.lifecycle.runtime.ktx)
            // ViewModel utilities for Compose
            implementation(libs.androidx.lifecycle.viewmodel.compose)
            // Lifecycle utilities for Compose
            implementation(libs.androidx.lifecycle.runtime.compose)
            // -----> End a lifecycle <----- //

            // Koin to dependency injection
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Coroutines & Json serialization
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)

            // Ktor to get data from network (api)
            implementation(libs.ktor.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            // ViewModel
            implementation(libs.mvvm.core)

            // Tabler Icons
            implementation(libs.tabler.icons)

            // Voyager to navigate (between pages or screens)
            implementation(libs.voyager.navigator)


            // Koin to dependency injection
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(kotlin("test-annotations-common"))
            implementation(libs.assertk)
            implementation(compose.uiTest)
            implementation(libs.mockk)
            implementation("app.cash.turbine:turbine:1.2.1")
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)

            // Ktor to get data from network (api)
            implementation(libs.ktor.client.okhttp)
        }
    }
}

android {
    namespace = "com.navigation.drawer"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.navigation.drawer"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    testImplementation(libs.junit.jupiter)
    debugImplementation(compose.uiTooling)

    testImplementation("app.cash.turbine:turbine:1.2.1")
}

compose.desktop {
    application {
        mainClass = "com.navigation.drawer.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.navigation.drawer"
            packageVersion = "1.0.0"
        }
    }
}
