dependencies {
    compileOnly("org.joml:joml:1.10.2")
    compileOnly("ink.ptms.core:v12004:12004:mapped")
    compileOnly("net.md-5:bungeecord-chat:1.17")
    compileOnly(project(":project:common"))
    compileOnly(project(":project:common-impl-nms"))
}

taboolib { subproject = true }