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
    api(project(Modules.core))
    implementation(project(Modules.core_ui))
    moxy()
    dagger()
    cicerone()

    testImplementation("junit:junit:4.12")
}
