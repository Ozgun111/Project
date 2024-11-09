// app/build.gradle.kts

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.compose")
}

android {
    compileOptions {
        sourceCompatibility JavaVersion_VERSION_1_8
                targetCompatibility JavaVersion_VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.yourname.thelostjournal"  // Specify your package name here

    compileSdk = 35 // Use the appropriate SDK version

    defaultConfig {
        applicationId = "com.yourname.thelostjournal"  // This can be the same as your namespace
        minSdk = 21
        //noinspection OldTargetApi
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Version of Compose you're using
    }

    buildFeatures {
        compose = true // Enable Jetpack Compose if using
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
