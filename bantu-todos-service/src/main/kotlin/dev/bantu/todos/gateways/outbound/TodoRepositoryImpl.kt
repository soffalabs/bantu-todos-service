package dev.bantu.todos.gateways.outbound

import dev.bantu.todos.api.model.Todo
import dev.bantu.todos.core.data.TodoRepository
import dev.bantu.todos.gateways.outbound.jpa.TodoJpaRepository
import dev.bantu.todos.gateways.outbound.jpa.TodoEntity
import org.springframework.stereotype.Component

@Component
class TodoRepositoryImpl(private val todos: TodoJpaRepository): TodoRepository {

    override fun save(model: Todo) {
        todos.save(TodoEntity.from(model))
    }

    override fun findAll(): List<Todo> {
        return todos.findAll().map { it.toModel() }
    }

    override fun findById(id: String): Todo? {
        return todos.findById(id).map { it.toModel() }.orElse(null)
    }

}
