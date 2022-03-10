package dev.bantu.todos.gateways.outbound

import dev.bantu.todos.api.schema.Todo
import dev.bantu.todos.ports.data.TodoRepository
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.data.SimpleEntityRepository
import org.springframework.stereotype.Component

@Component
class TodoRepositoryImpl(db: DB) : SimpleEntityRepository<Todo>(db, Todo::class.java), TodoRepository
