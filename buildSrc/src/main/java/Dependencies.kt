import Versions.KOTLIN
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPlugin.*
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

private fun DependencyHandler.test(dependency: String) =
    add(TEST_IMPLEMENTATION_CONFIGURATION_NAME, dependency)



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

fun DependencyHandler.groupie() {
    val groupieVersion = "2.3.0"
    api("com.xwray:groupie:$groupieVersion")
    api("com.xwray:groupie-databinding:$groupieVersion")
}

fun DependencyHandler.lottie() {
    val lottieVersion = "3.0.1"
    implementation("com.airbnb.android:lottie:$lottieVersion")
}

fun DependencyHandler.network() {
    val okhttpVersion = "3.12.3"
    api("com.squareup.okhttp3:okhttp:$okhttpVersion")
    api("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    val retrofitVersion = "2.6.0"
    api("com.squareup.retrofit2:retrofit:$retrofitVersion")
    api("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    api("com.squareup.retrofit2:converter-simplexml:$retrofitVersion")
}

fun DependencyHandler.testHamcrest() {
    test("org.hamcrest:hamcrest:2.1")
}

fun DependencyHandler.project(module: LibModules): Dependency = project(module.path)
