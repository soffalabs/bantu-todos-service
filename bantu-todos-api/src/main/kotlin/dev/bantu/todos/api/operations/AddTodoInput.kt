package dev.bantu.todos.api.operations

import javax.validation.constraints.NotEmpty

open class AddTodoInput(
    @NotEmpty
    val content: String? = null
)
