plugins {
    androidLib()
}

android {
    applyUiLibConfig()
}

dependencies {
    api(project(LibModules.CORE))
    constraintLayout()
    appCompat()
    moxy()
    dagger()
    cicerone()
    groupie()
    api("com.jakewharton.rxbinding2:rxbinding:2.2.0")

    testImplementation("junit:junit:4.12")
}
