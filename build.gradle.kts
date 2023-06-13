import app.futured.academyproject.Clean
import app.futured.academyproject.DependencyUpdates
import app.futured.academyproject.LintCheck
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(Dependencies.gradlePlugin)
        classpath(kotlin(Dependencies.Kotlin.gradlePlugin, Versions.kotlin))
        classpath(Dependencies.hiltPlugin)
    }
}

plugins {
    idea
    id(Dependencies.Plugins.detekt) version Versions.detekt
    id(Dependencies.Plugins.ktlint) version Versions.ktlintGradle
}

tasks {
    register<Clean>("clean")
    register<LintCheck>("lintCheck")
    register<DependencyUpdates>("dependencyUpdates")
}

allprojects {
    repositories {
        google()
        maven { setUrl("https://jitpack.io") }
        gradlePluginPortal()
    }
}

subprojects {
    apply(plugin = Dependencies.Plugins.ktlint)
    ktlint.apply {
        version.set(Versions.ktlint)
        ignoreFailures.set(true)
        android.set(true)
        outputToConsole.set(true)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
    }
}

detekt.apply {
    version = Versions.detekt
    source = files(rootDir, "buildSrc/")
    config = files("$rootDir/detekt.yml")
    allRules = false
}

ktlint.apply {
    version.set(Versions.ktlint)
    ignoreFailures.set(true)
    android.set(true)
    outputToConsole.set(true)
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
    }
}
