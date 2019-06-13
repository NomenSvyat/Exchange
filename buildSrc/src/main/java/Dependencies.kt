import Versions.KOTLIN
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.API_CONFIGURATION_NAME
import org.gradle.api.plugins.JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME
import org.gradle.kotlin.dsl.exclude
import org.gradle.kotlin.dsl.project

object Versions {
    const val KOTLIN = "1.3.31"
}

private const val KAPT_CONFIGURATION_NAME = "kapt"

private fun DependencyHandler.api(dependency: String) =
    add(API_CONFIGURATION_NAME, dependency)

private fun DependencyHandler.implementation(dependency: String) =
    add(IMPLEMENTATION_CONFIGURATION_NAME, dependency)

private fun DependencyHandler.kapt(dependency: String) =
    add(KAPT_CONFIGURATION_NAME, dependency)

fun DependencyHandler.kotlin() {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN")
}

fun DependencyHandler.constraintLayout() {
    api("androidx.constraintlayout:constraintlayout:1.1.3")
}

fun DependencyHandler.appCompat() {
    api("androidx.appcompat:appcompat:1.0.2")
}

fun DependencyHandler.rx() {
    api("io.reactivex.rxjava2:rxjava:2.2.9")
    api("io.reactivex.rxjava2:rxandroid:2.1.1")
}

fun DependencyHandler.moxy() {
    val moxyVersion = "1.5.3"
    api("com.arello-mobile:moxy:$moxyVersion")
    kapt("com.arello-mobile:moxy-compiler:$moxyVersion")
}

fun DependencyHandler.dagger() {
    val daggerVersion = "2.23.1"
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
}

fun DependencyHandler.cicerone() {
    implementation("ru.terrakok.cicerone:cicerone:5.0.0")
}

fun DependencyHandler.network() {
    val okhttpVersion = "3.11.0"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    val retrofitVersion = "2.4.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")

    val tikxmlVersion = "0.8.13"
    implementation("com.tickaroo.tikxml:retrofit-converter:$tikxmlVersion")
        ?.let { it as? ModuleDependency }
        ?.exclude("com.tickaroo.tikxml")
    implementation("com.tickaroo.tikxml:core:$tikxmlVersion")
    implementation("com.tickaroo.tikxml:annotation:0.8.13")
    kapt("com.tickaroo.tikxml:processor:$tikxmlVersion")

}

fun DependencyHandler.project(module: LibModules): Dependency = project(module.path)
