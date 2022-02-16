package dev.bantu.todos.api.model

import javax.validation.constraints.NotEmpty

data class AddTodoInput(
    @NotEmpty
    val content: String? = null
)