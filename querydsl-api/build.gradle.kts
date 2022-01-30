tasks {
    bootJar {
        enabled = true
    }
    jar {
        enabled = true
    }
}


dependencies {
    implementation(project(":querydsl-domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}