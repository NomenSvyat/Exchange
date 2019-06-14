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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dataBinding {
        isEnabled = true
    }
}


dependencies {
    kotlin()
    constraintLayout()
    moxy()
    dagger()
    cicerone()

    LibModules.values().forEach { implementation(project(it.path)) }

    testImplementation("junit:junit:4.12")
}
