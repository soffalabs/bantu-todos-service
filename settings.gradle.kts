rootProject.name = "bantu-todos"

listOf("api", "service").forEach {
    include(":app-$it")
    project(":app-$it").name = rootProject.name + "-$it"
}
