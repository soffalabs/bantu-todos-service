package dev.bantu.todos.core.data

import dev.bantu.todos.api.model.Todo
import io.soffa.foundation.core.data.EntityRepository

interface TodoRepository: EntityRepository<Todo>
