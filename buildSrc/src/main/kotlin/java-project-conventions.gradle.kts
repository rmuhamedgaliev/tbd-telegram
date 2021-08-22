plugins {
    java
}

version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    named<Test>("test") {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
    }
}