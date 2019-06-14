plugins {
    androidLib()
}

android {
    applyUiLibConfig()
}

kapt {
    arguments {
        arg("moxyReflectorPackage", "com.nomensvyat.exchange.exchanger")
    }
}

dependencies {
    implementation(project(LibModules.CORE_UI))
    moxy()
    dagger()
    cicerone()

    testImplementation("junit:junit:4.12")
}
