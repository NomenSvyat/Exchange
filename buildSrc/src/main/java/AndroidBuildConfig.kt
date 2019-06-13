import com.android.build.gradle.LibraryExtension

object AndroidBuildConfig {
    const val COMPILE_SDK = 28
    const val MIN_SDK = 21
    const val TARGET_SDK = 28
}

fun LibraryExtension.applyDefaultLibConfig() {
    compileSdkVersion(AndroidBuildConfig.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(AndroidBuildConfig.MIN_SDK)
        targetSdkVersion(AndroidBuildConfig.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}