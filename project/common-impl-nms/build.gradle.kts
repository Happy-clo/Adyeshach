dependencies {
    compileOnly(project(":project:common"))
    compileOnly(project(":project:common-impl"))
    compileOnly(project(":project:api-data-serializer"))
    compileOnly("ink.ptms.core:v11900:11900:mapped")
    compileOnly("ink.ptms.core:v11900:11900:universal")
    compileOnly("ink.ptms.core:v11903:11903:mapped")
    compileOnly("ink.ptms.core:v11904:11904.2-minimize:mapped")
    compileOnly("ink.ptms.core:v11800:11800:mapped")
    compileOnly("net.md-5:bungeecord-chat:1.21-R0.1")
}

taboolib { subproject = true }