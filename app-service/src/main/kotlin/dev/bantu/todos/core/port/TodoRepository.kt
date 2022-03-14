package dev.bantu.todos.core.port

import dev.bantu.todos.api.schema.Todo
import dev.soffa.foundation.annotation.Repository
import dev.soffa.foundation.data.EntityRepository

@Repository(collection= "todos")
interface TodoRepository: EntityRepository<Todo>
