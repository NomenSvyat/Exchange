import Versions.KOTLIN
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.API_CONFIGURATION_NAME
import org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME

object Versions {
    const val KOTLIN = "1.3.31"
}

private const val KAPT_CONFIGURATION_NAME = "kapt"

fun DependencyHandler.kotlin() {
    add(API_CONFIGURATION_NAME, "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN")
}

fun DependencyHandler.constraintLayout() {
    add(API_CONFIGURATION_NAME, "androidx.constraintlayout:constraintlayout:1.1.3")
}

fun DependencyHandler.appCompat() {
    add(API_CONFIGURATION_NAME, "androidx.appcompat:appcompat:1.0.2")
}

fun DependencyHandler.rx() {
    add(API_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxjava:2.2.9")
    add(API_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxandroid:2.1.1")
}

fun DependencyHandler.moxy() {
    val moxyVersion = "1.5.3"
    add(API_CONFIGURATION_NAME, "com.arello-mobile:moxy:$moxyVersion")
    add(KAPT_CONFIGURATION_NAME, "com.arello-mobile:moxy-compiler:$moxyVersion")
}

fun DependencyHandler.dagger() {
    val daggerVersion = "2.23.1"
    add(IMPLEMENTATION_CONFIGURATION_NAME, "com.google.dagger:dagger:$daggerVersion")
    add(KAPT_CONFIGURATION_NAME, "com.google.dagger:dagger-compiler:$daggerVersion")
}

fun DependencyHandler.cicerone() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "ru.terrakok.cicerone:cicerone:5.0.0")
}
