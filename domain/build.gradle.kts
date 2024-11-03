plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOVER)
}

android {
    namespace = "com.studio35.domain"
    compileSdk = Versions.ANDROID_COMPILE_SDK
    buildToolsVersion = Versions.ANDROID_COMPILE_SDK.toString()

    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }

    lint {
        checkDependencies = true
        xmlReport = true
        xmlOutput = file("build/reports/lint/lint-result.xml")
    }
}

dependencies {
    with(Dependencies.Kotlin) {
        implementation(COROUTINES_CORE)
    }

    with(Dependencies.Hilt) {
        implementation(JAVAX_INJECT)
    }

    with(Dependencies.Test) {
        testImplementation(COROUTINES)
        testImplementation(JUNIT)
        testImplementation(KOTEST)
        testImplementation(MOCKK)
    }
}
