plugins {
    androidLib()
}

android {
    applyDefaultLibConfig()
}

dependencies {
    api(project(Modules.core))
    kotlin()
    constraintLayout()
    appCompat()
    rx()
    moxy()
    dagger()
    cicerone()

    testImplementation("junit:junit:4.12")
}
