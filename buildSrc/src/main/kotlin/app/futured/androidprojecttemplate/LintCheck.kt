package app.futured.androidprojecttemplate

import ProjectSettings
import org.gradle.api.DefaultTask
import org.gradle.api.plugins.ExtraPropertiesExtension
import org.gradle.kotlin.dsl.configure

open class LintCheck : DefaultTask() {

    init {
        group = ProjectSettings.TASK_GROUP

        configure<ExtraPropertiesExtension> {
            dependsOn("ktlintCheck")
            dependsOn("detekt")
            project.subprojects.forEach {
                dependsOn("${it.name}:ktlintCheck")
                dependsOn("${it.name}:lintDevEnterprise")
            }
        }
    }
}
