import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.kotlin() {
    id("kotlin-android")
    kotlin("kapt")
}
