plugins {
    androidLib()
}

android {
    applyUiLibConfig()
}

kapt {
    arguments {
        arg("moxyReflectorPackage", "com.nomensvyat.exchange.splashscreen")
    }
}

dependencies {
    implementation(project(LibModules.CORE_UI))
    moxy()
    dagger()
    cicerone()
    lottie()

    testImplementation("junit:junit:4.12")
}
