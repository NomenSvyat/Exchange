plugins {
    id("com.android.library")
    kotlin()
}

android {
    applyDefaultLibConfig()
}

dependencies {
    kotlin()
    rx()
    api("com.jakewharton.timber:timber:4.7.1")


    testImplementation("junit:junit:4.12")
}
