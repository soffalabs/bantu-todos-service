package dev.bantu.todos.gateways.outbound

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.core.data.TodoRepository
import io.soffa.foundation.core.data.DB
import io.soffa.foundation.service.data.SimpleEntityRepository
import org.springframework.stereotype.Component

@Component
class TodoRepositoryImpl(db: DB) : SimpleEntityRepository<Todo>(db, Todo::class.java), TodoRepository
