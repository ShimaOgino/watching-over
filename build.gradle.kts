// プラグインの設定
plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.github.node-gradle.node") version "3.1.0"
    java
}

group = "jp.promari"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("src/main/java")
    }
}

// 依存関係の設定
dependencies {
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("org.slf4j:slf4j-api:2.0.6")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt:0.2")
    implementation("javax.activation:javax.activation-api:1.2.0")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("com.sun.xml.bind:jaxb-core:2.3.0.1")
    implementation("org.json:json:20210307")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    runtimeOnly("com.h2database:h2")

    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

// Node.jsとnpmの設定
node {
    version = "14.17.3"
    download = true
    workDir = file("$projectDir/frontend")
    npmWorkDir = file("$projectDir/frontend")
}

// タスクの定義
tasks {

    register<Exec>("installReactDependencies") {
        group = "setup"
        description = "Install React frontend dependencies"
        workingDir = file("frontend")
        commandLine("npm", "install")
    }
    register<Exec>("installReactRouter") {
        group = "setup"
        description = "Install React Router and Axios for the frontend"
        workingDir = file("frontend")
        commandLine("npm", "install", "react-router-dom", "axios")
    }

    register<Exec>("buildReact") {
        dependsOn("installReactDependencies", "installReactRouter")
        group = "build"
        description = "Build the React frontend"
        workingDir = file("frontend")
        commandLine("npm", "run", "build")
    }

    register<Copy>("copyReactToStatic") {
        dependsOn("buildReact")
        from("frontend/build/")
        into("src/main/resources/static")
    }

    named("processResources") {
        dependsOn("copyReactToStatic")
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
