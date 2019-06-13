plugins {
    id("com.android.application")
    kotlin()
}

android {
    compileSdkVersion(AndroidBuildConfig.COMPILE_SDK)
    defaultConfig {
        applicationId = "com.nomensvyat.exchange"
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

val libModules = listOf(
    ":core",
    ":core_ui"
)

dependencies {
    kotlin()
    constraintLayout()
    appCompat()
    rx()
    moxy()
    dagger()

    libModules.forEach { implementation(project(it)) }

    testImplementation("junit:junit:4.12")
}
