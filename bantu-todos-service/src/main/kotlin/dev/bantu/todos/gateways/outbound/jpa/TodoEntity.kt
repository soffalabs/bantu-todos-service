package dev.bantu.todos.gateways.outbound.jpa

import dev.bantu.todos.api.model.Todo
import io.soffa.foundation.commons.BeanUtil
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "todos")
data class TodoEntity(
    @Id
    val id: String? = null,
    val content: String? = null,
    @Enumerated(EnumType.STRING)
    val status: TodoStatus? = null,
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: Date? = null
) {

    fun toModel(): Todo {
        return Todo(
            id = id!!,
            content = content!!,
            done = status == TodoStatus.DONE,
            createdAt = createdAt!!.toInstant().toEpochMilli()
        )
    }

    companion object {

        fun from(todo: Todo): TodoEntity {
            return TodoEntity(
                id = todo.id,
                content = todo.content,
                status = if (todo.done == true) TodoStatus.DONE else TodoStatus.PENDING,
                createdAt = Date(todo.createdAt!!)
            )
        }

    }
}
