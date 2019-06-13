import Versions.KOTLIN
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME

object Versions {
    const val KOTLIN = "1.3.31"
}

fun <T : DependencyHandler> T.kotlin() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN")
}

fun <T : DependencyHandler> T.constraintLayout() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.constraintlayout:constraintlayout:1.1.3")
}

fun <T : DependencyHandler> T.appCompat() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "androidx.appcompat:appcompat:1.0.2")
}

fun <T : DependencyHandler> T.rx() {
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxjava:2.2.9")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxandroid:2.1.1")
}

fun <T : DependencyHandler> T.moxy() {
    val moxyVersion = "1.7.0"
    add(IMPLEMENTATION_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x-androidx:$moxyVersion")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x:$moxyVersion")
    add(KAPT_CONFIGURATION_NAME, "tech.schoolhelper:moxy-x-compiler:$moxyVersion")
}

fun <T : DependencyHandler> T.dagger() {
    val daggerVersion = "2.23.1"
    add(KAPT_CONFIGURATION_NAME, "com.google.dagger:dagger:$daggerVersion")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "com.google.dagger:dagger-compiler:$daggerVersion")
}

private const val KAPT_CONFIGURATION_NAME = "kapt"