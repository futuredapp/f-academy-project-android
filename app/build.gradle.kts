@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.kotlin
    id("dagger.hilt.android.plugin")
}

android.apply {
    compileSdk = ProjectSettings.compileSdkVersion
    namespace = ProjectSettings.applicationId

    defaultConfig {
        applicationId = ProjectSettings.applicationId
        minSdk = ProjectSettings.minSdk
        targetSdk = ProjectSettings.targetSdk
        versionCode = ProjectSettings.versionCode
        versionName = ProjectSettings.versionName

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments.apply {
                    put("room.schemaLocation", "$projectDir/schemas")
                }
            }
        }
    }

    packagingOptions {
        resources.excludes += setOf(
            "META-INF/DEPENDENCIES",
            "META-INF/LICENSE",
            "README.md",
        )
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions.apply {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerVersion
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }

    sourceSets {
        getByName("main").java.setSrcDirs(setOf("src/main/kotlin"))
        create(ProjectSettings.Flavor.DEV).java.setSrcDirs(setOf("src/dev/kotlin"))
        create(ProjectSettings.Flavor.PROD).java.setSrcDirs(setOf("src/prod/kotlin"))
        create(ProjectSettings.Flavor.MOCK).java.setSrcDirs(setOf("src/mock/kotlin"))
        getByName("test").java.setSrcDirs(setOf("src/test/kotlin"))
        getByName("androidTest").java.setSrcDirs(setOf("src/androidTest/kotlin"))
    }

    signingConfigs {
        getByName(ProjectSettings.BuildType.DEBUG) {
            storeFile = rootProject.file("./keystore/debug.jks")
            storePassword = ProjectSettings.Debug.STORE_PASSWORD
            keyAlias = ProjectSettings.Debug.KEY_ALIAS
            keyPassword = ProjectSettings.Debug.KEY_PASSWORD
        }
        create(ProjectSettings.BuildType.RELEASE) {
            storeFile = rootProject.file("./keystore/release.jks")
            storePassword = ProjectSettings.Release.STORE_PASSWORD
            keyAlias = ProjectSettings.Release.KEY_ALIAS
            keyPassword = ProjectSettings.Release.KEY_PASSWORD
        }
    }

    buildTypes {
        buildTypes {
            getByName(ProjectSettings.BuildType.DEBUG) {
                isMinifyEnabled = false
                isShrinkResources = false
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.DEBUG)
            }
            create(ProjectSettings.BuildType.ENTERPRISE) {
                isDebuggable = true
                isMinifyEnabled = true
                isShrinkResources = true
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.DEBUG)
                proguardFile(getDefaultProguardFile("proguard-android.txt"))
                proguardFile(file("proguard-rules.pro"))
            }
            getByName(ProjectSettings.BuildType.RELEASE) {
                isMinifyEnabled = true
                isShrinkResources = true
                signingConfig = signingConfigs.getByName(ProjectSettings.BuildType.RELEASE)
                proguardFile(getDefaultProguardFile("proguard-android.txt"))
                proguardFile(file("proguard-rules.pro"))
            }
        }
    }

    flavorDimensions.add(ProjectSettings.Flavor.DIMENSION)

    productFlavors {
        create(ProjectSettings.Flavor.MOCK) {
            dimension = ProjectSettings.Flavor.DIMENSION
        }
        create(ProjectSettings.Flavor.DEV) {
            dimension = ProjectSettings.Flavor.DIMENSION
        }
        create(ProjectSettings.Flavor.PROD) {
            dimension = ProjectSettings.Flavor.DIMENSION
        }
    }

    lint {
        textReport = true // Write a text report to the console (Useful for CI logs)
        xmlReport = true // Write XML report
        abortOnError = false // Do not abort build when error is found -> Danger will report this to the MR
        explainIssues = false // HTML/XML reports are too verbose in console logs
        checkDependencies = false // Required to get all unused resource from other modules (disabled to speed up linting)
        checkTestSources = true // Also check test case code for lint issues
        checkReleaseBuilds = false // If we run a full lint analysis as build part in CI, we can skip redundant checks
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    // Kotlin
    implementation(platform(Dependencies.Kotlin.kotlinReflect))
    implementation(Dependencies.Kotlin.kotlinCollections)

    // Support
    implementation(Dependencies.Support.appcompat)
    implementation(Dependencies.Support.ktx)
    implementation(Dependencies.Support.lifecycleViewModel)
    implementation(Dependencies.Support.lifecycleRuntime)
    implementation(Dependencies.Support.activityKtx)
    implementation(Dependencies.Support.lifecycleCompiler)
    implementation(Dependencies.Support.preference)
    coreLibraryDesugaring(Dependencies.Support.desugarLibs)

    // Compose
    implementation(Dependencies.Compose.animation)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.foundation_layout)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.material_icons_extended)
    implementation(Dependencies.Compose.runtime_livedata)
    implementation(Dependencies.Compose.runtime)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.ui_tooling)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.constraintLayout)

    // MVVM
    implementation(Dependencies.Taste.mvvmCrInteractors)

    // Hilt
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)

    // NavigationComponents
    implementation(Dependencies.NavigationComponents.navigation)
    implementation(Dependencies.NavigationComponents.navigationHilt)

    // Networking
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.logging)
    implementation(Dependencies.Networking.retrofit)

    // Serialization
    implementation(Dependencies.Serialization.serializationJson)
    implementation(Dependencies.Serialization.converter)

    // Other
    implementation(Dependencies.Other.timber)
    implementation(Dependencies.Other.coil)

    // Testing
    testImplementation(Dependencies.Test.core)
    testImplementation(Dependencies.Test.runner)
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockk)

    androidTestImplementation(Dependencies.Test.core)
    androidTestImplementation(Dependencies.Test.runner)
    androidTestImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.mockk)

    // Lint
    lintChecks(Dependencies.Lint.composeLint)
}
