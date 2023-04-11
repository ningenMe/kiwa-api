import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.openapi.generator") version "6.5.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "ningenme.net"
version = ""
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.1")
    implementation("com.mysql:mysql-connector-j:8.0.32")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //openapi
    compileOnly("io.swagger.core.v3:swagger-annotations:2.2.8")
    compileOnly("io.swagger.core.v3:swagger-models:2.2.8")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")

//    implementation("org.springframework.session:spring-session-data-redis:3.0.0")
//    implementation("io.lettuce:lettuce-core:6.2.3.RELEASE")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    bootJar {
        archiveBaseName.set(rootProject.name)
        launchScript()
    }
}

tasks.register("kotlinSpringServerGenerate", GenerateTask::class) {
    group = "openapi tools"
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/openapi/openapi.yaml")
    outputDir.set("$rootDir")
    apiPackage.set("ningenme.net.kiwaapi.application.generated.controller")
    modelPackage.set("ningenme.net.kiwaapi.application.generated.view")
    modelNameSuffix.set("view")
    generateModelTests.set(false)
    generateApiTests.set(false)
    generateModelDocumentation.set(false)
    generateApiDocumentation.set(false)
    configOptions.set(
        mutableMapOf(
            "dateLibrary" to "java8",
            "interfaceOnly" to "true",
            "skipDefaultInterface" to "true",
            "useTags" to "true",
            "useSpringBoot3" to "true"
        )
    )
}
tasks.register("typescriptClientGenerate", GenerateTask::class) {
    group = "openapi tools"
    generatorName.set("typescript-axios")
    inputSpec.set("$rootDir/openapi/openapi.yaml")
    outputDir.set("$rootDir/client")

    configOptions.set(
        mutableMapOf(
            "useTags" to "true",
        )
    )
}

