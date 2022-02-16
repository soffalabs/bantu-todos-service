package dev.bantu.todos.api.model

import javax.validation.constraints.NotEmpty

data class CompleteTodoInput(
    @NotEmpty
    val id: String? = null
)
