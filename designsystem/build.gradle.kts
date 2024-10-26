plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.COMPOSE_COMPILER)
    id(Plugins.KOVER)
}

android {
    namespace = "com.studio35.designsystem"
    compileSdk = Versions.ANDROID_COMPILE_SDK

    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {
    with(Dependencies.AndroidX) {
        implementation(CORE_KTX)
        implementation(APP_COMPAT)
        implementation(LIFECYCLE_RUNTIME_KTX)
        implementation(LIFECYCLE_RUNTIME_COMPOSE)
    }

    with(Dependencies.Compose) {
        implementation(platform(BOM))
        implementation(UI)
        implementation(FOUNDATION)
        implementation(UI_TOOLING)
        implementation(MATERIAL)
        implementation(NAVIGATION)
        implementation(UI_GRAPHICS)
    }
}