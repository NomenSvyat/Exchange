import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

fun LibraryExtension.applyUiLibConfig() {
    applyDefaultLibConfig()
    dataBinding {
        isEnabled = true
    }
}