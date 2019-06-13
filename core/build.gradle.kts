plugins {
    id("com.android.library")
    kotlin()
}

android {
    compileSdkVersion(AndroidBuildConfig.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(AndroidBuildConfig.MIN_SDK)
        targetSdkVersion(AndroidBuildConfig.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    kotlin()
    rx()

    testImplementation("junit:junit:4.12")
}
