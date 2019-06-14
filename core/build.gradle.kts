plugins {
    androidLib()
}

android {
    applyDefaultLibConfig()
}

dependencies {
    kotlin()
    rx()
    dagger()
    api("com.jakewharton.timber:timber:4.7.1")


    testImplementation("junit:junit:4.12")
}
