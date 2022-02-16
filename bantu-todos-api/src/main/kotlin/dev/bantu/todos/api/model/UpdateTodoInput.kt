package dev.bantu.todos.api.model

import javax.validation.constraints.NotEmpty

data class UpdateTodoInput(
    @NotEmpty
    val id: String? = null,
    @NotEmpty
    val content: String? = null
)
