package dev.bantu.todos.ports.data

import dev.bantu.todos.api.schema.Todo
import dev.soffa.foundation.data.EntityRepository

interface TodoRepository: EntityRepository<Todo>
