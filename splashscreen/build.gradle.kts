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
    api(project(LibModules.CORE))
    implementation(project(LibModules.CORE_UI))
    moxy()
    dagger()
    cicerone()

    testImplementation("junit:junit:4.12")
}
