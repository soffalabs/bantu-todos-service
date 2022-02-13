// Nom du projet à personnaliser
rootProject.name = "bantu-todos"

// Indique à Gradle qu'il s'agit d'un projet composé de 3 modules
include(":bantu-todos-api")
include(":bantu-todos-core") // utilise :banu-todos-api
include(":bantu-todos-service") // utilise :banu-todos-service



