tasks {
    bootJar {
        enabled = false
    }
    jar {
        enabled = true
    }
}

kotlin.sourceSets.main {
    setBuildDir("src/generated/kotlin")
}
