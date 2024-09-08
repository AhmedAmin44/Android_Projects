import org.jetbrains.kotlin.gradle.plugin.KaptExtension

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id ("com.google.dagger.hilt.android")
}


android {
    namespace = "com.example.appapi"
    compileSdk = 33
buildFeatures{
    viewBinding=true
}
    defaultConfig {
        applicationId = "com.example.app"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true // Recommended for Kotlin + Hilt to avoid some common errors
}
