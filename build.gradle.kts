plugins {
    `java-library`
    `maven-publish`
    signing
    id("org.sonarqube") version "3.3"
}

group = "dev.tobee"
version = "0.0.1"

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

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junitVersion}")

    testImplementation("uk.org.webcompere:system-stubs-core:1.2.0")
    testImplementation("uk.org.webcompere:system-stubs-jupiter:1.2.0")
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
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
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
            // change URLs to point to your repos, e.g. http://my.org/repo
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
    }
}
