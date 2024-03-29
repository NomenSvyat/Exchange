import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.kotlin() {
    kotlin("android")
    kotlin("kapt")
}

fun PluginDependenciesSpec.androidLib() {
    id("com.android.library")
    kotlin()
}