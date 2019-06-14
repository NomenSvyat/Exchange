plugins {
    androidLib()
}

android {
    applyDefaultLibConfig()
}

dependencies {
    api(project(LibModules.CORE))
    dagger()
    network()

    testImplementation("junit:junit:4.12")
    testHamcrest()
}
