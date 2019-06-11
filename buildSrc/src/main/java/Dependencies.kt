import Versions.KOTLIN
import Versions.RX
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME

object AndroidBuildConfig {
    const val COMPILE_SDK = 28
    const val MIN_SDK = 21
    const val TARGET_SDK = 28
}

object Versions {
    const val KOTLIN = "1.3.31"
    const val RX = "2.2.9"
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
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxjava:$RX")
    add(IMPLEMENTATION_CONFIGURATION_NAME, "io.reactivex.rxjava2:rxandroid:2.1.1")
}

fun <T : DependencyHandler> T.moxy() {

}