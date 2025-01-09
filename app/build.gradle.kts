plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android) version "2.0.21"
    id("com.google.devtools.ksp") version "2.0.21-1.0.27"
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.veterinaria"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.veterinaria"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val lifecycle_version = "2.8.7"
    val activity_version = "1.9.2"
    val room_version = "2.6.1"
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.activity:activity-ktx:$activity_version")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt ("com.github.bumptech.glide:compiler:4.12.0")
    ksp("androidx.room:room-compiler:$room_version")
}