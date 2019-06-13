plugins {
    androidLib()
}

android {
    applyUiLibConfig()
}

dependencies {
    api(project(Modules.core))
    constraintLayout()
    appCompat()
    moxy()
    dagger()
    cicerone()

    testImplementation("junit:junit:4.12")
}
