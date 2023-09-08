dependencies {
    compileOnly("public:GermPlugin:4.1.8")
    compileOnly(project(":project:common"))
    compileOnly(project(":project:common-impl"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}