package dev.bantu.todos.api.schema

import javax.validation.constraints.NotEmpty

open class AddTodoInput(
    @NotEmpty
    val content: String? = null
)
