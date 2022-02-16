package dev.bantu.todos.gateways.outbound

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.core.data.TodoRepository
import dev.bantu.todos.gateways.outbound.jpa.MessageJpaRepository
import dev.bantu.todos.gateways.outbound.jpa.TodoEntity
import org.springframework.stereotype.Component

@Component
class TodoRepositoryImpl(private val messages: MessageJpaRepository): TodoRepository {

    override fun save(model: Todo) {
        messages.save(TodoEntity.from(model))
    }

    override fun findAll(): List<Todo> {
        return messages.findAll().map { it.toModel() }
    }

}
