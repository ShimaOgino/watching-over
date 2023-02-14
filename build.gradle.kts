plugins {
	java
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "jp.promari"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_19

repositories {
	mavenCentral()
}

dependencies {
  // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot
  implementation("org.springframework.boot:spring-boot:3.0.2")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("io.jsonwebtoken:jjwt:0.2")
  implementation("org.projectlombok:lombok")
  // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
  implementation("org.slf4j:slf4j-api:2.0.6")
  implementation("org.springframework.boot:spring-boot-devtools")

  // https://mvnrepository.com/artifact/mysql/mysql-connector-java
  implementation("mysql:mysql-connector-java:8.0.32")

  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
