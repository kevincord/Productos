plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

        implementation 'org.springframework.boot:spring-boot-starter-tomcat'
        providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'


}

tasks.test {
    useJUnitPlatform()
}