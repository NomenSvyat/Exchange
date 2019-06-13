import Versions.KOTLIN
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.ANNOTATION_PROCESSOR_CONFIGURATION_NAME
import org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME

object Versions {
    const val KOTLIN = "1.3.31"
}

private const val KAPT_CONFIGURATION_NAME = "kapt"

fun DependencyHandler.kotlin() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN")
}

fun DependencyHandler.constraintLayout() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.constraintlayout:constraintlayout:1.1.3")
}

fun DependencyHandler.appCompat() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.appcompat:appcompat:1.0.2")
}

fun DependencyHandler.rx() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxjava:2.2.9")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxandroid:2.1.1")
}

fun DependencyHandler.moxy() {
    val moxyVersion = "1.7.0"
    add(IMPLEMENTATION_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x-androidx:$moxyVersion")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x:$moxyVersion")
    add(KAPT_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x-compiler:$moxyVersion")
}

fun DependencyHandler.dagger() {
    val daggerVersion = "2.23.1"
    add(IMPLEMENTATION_CONFIGURATION_NAME, "com.google.dagger:dagger:$daggerVersion")
    add(KAPT_CONFIGURATION_NAME, "com.google.dagger:dagger-compiler:$daggerVersion")
}