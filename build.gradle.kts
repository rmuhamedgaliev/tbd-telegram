val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra

plugins {
    `java-library`
    `maven-publish`
    `project-report`
    `build-dashboard`
    jacoco
    signing
    id("org.sonarqube") version "3.3"
    id("org.shipkit.shipkit-changelog") version "1.1.15"
    id("org.shipkit.shipkit-github-release") version "1.1.15"
    id("org.shipkit.shipkit-auto-version") version "1.1.19"
    id("com.palantir.git-version") version "0.12.3"
}

group = "dev.tobee"
version = "0.0.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:${Versions.jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-annotations:${Versions.jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${Versions.jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:${Versions.jacksonVersion}")

    implementation("org.apache.commons:commons-text:${Versions.commonsVersion}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${Versions.log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-core:${Versions.log4jVersion}")
    implementation("org.apache.logging.log4j:log4j-api:${Versions.log4jVersion}")
    implementation("org.slf4j:slf4j-api:${Versions.slf4jApiVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junitVersion}")

    testImplementation("org.mockito:mockito-core:${Versions.mockitoVersion}")
    testImplementation("org.mockito:mockito-junit-jupiter:${Versions.mockitoVersion}")

    testImplementation("uk.org.webcompere:system-stubs-core:${Versions.systemStubsVersion}")
    testImplementation("uk.org.webcompere:system-stubs-jupiter:${Versions.systemStubsVersion}")
}

tasks.test {
    useJUnitPlatform()
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "tbd-telegram-sdk"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }


            pom {
                name.set("tbd-telegram-sdk")
                description.set("TBD Telegram SDK - a simple Java Telegram BOT Api client. It have small footprint and use Java 11 async HTTP client \n" +
                        "with latest Java syntax.")
                url.set("https://tobee.dev")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/rmuhamedgaliev/tbd-telegram/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("rmuhamedgaliev")
                        name.set("Rinat Muhamedgaliev")
                        email.set("rinat.muhamedgaliev@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/rmuhamedgaliev/tbd-telegram.git")
                    developerConnection.set("scm:git:ssh://github.com/rmuhamedgaliev/tbd-telegram.git")
                    url.set("https://github.com/rmuhamedgaliev/tbd-telegram")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                val ossrhUsername: String? by project
                val ossrhPassword: String? by project
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "rmuhamedgaliev_tbd-telegram")
        property("sonar.organization", "rmuhamedgaliev")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.core.codeCoveragePlugin", "jacoco")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
        property("sonar.exclusions", "src/main/java/dev/tobee/telegram/model/**/*.java")
    }
}

tasks.generateChangelog {
    repository = "rmuhamedgaliev/tbd-telegram"
    previousRevision = project.ext["shipkit-auto-version.previous-tag"]?.toString()
    githubToken = System.getenv("GITHUB_PACKAGE_TOKEN")
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(true)
    }
}

tasks.test {
    finalizedBy("jacocoTestReport")
    doLast {
        println("View code coverage at:")
        println("file://$buildDir/reports/jacoco/test/html/index.html")
    }
}

tasks.githubRelease {
    dependsOn(tasks.generateChangelog)
    repository = "rmuhamedgaliev/tbd-telegram"
    changelog = tasks.generateChangelog.get().outputFile
    githubToken = System.getenv("GITHUB_PACKAGE_TOKEN")
    newTagRevision = versionDetails().gitHashFull
}
