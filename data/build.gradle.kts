plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOVER)
}

android {
    namespace = "com.studio35.data"
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
    implementation(project(Modules.DOMAIN))

    with(Dependencies.AndroidX) {
        implementation(CORE_KTX)
        implementation(DATASTORE_PREFERENCES)
        implementation(SECURITY_CRYPTO)
    }

    with(Dependencies.Hilt) {
        implementation(JAVAX_INJECT)
    }

    with(Dependencies.Network) {
        api(RETROFIT)
        api(RETROFIT_CONVERTER_MOSHI)

        api(platform(OKHTTP_BOM))
        api(OKHTTP)
        api(OKHTTP_LOGGING_INTERCEPTOR)

        api(MOSHI)
        implementation(MOSHI_ADAPTERS)
        implementation(MOSHI_KOTLIN)
    }

    with(Dependencies.Test) {
        testImplementation(COROUTINES)
        testImplementation(JUNIT)
        testImplementation(KOTEST)
        testImplementation(MOCKK)
        testImplementation(ROBOLECTRIC)
        testImplementation(TEST_CORE)
        testImplementation(TURBINE)
    }
}
