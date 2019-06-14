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

    testImplementation("junit:junit:4.12")
}
