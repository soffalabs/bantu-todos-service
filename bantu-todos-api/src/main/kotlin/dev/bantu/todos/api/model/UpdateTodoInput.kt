package dev.bantu.todos.api.model

import io.swagger.v3.oas.annotations.Parameter
import javax.validation.constraints.NotEmpty

data class UpdateTodoInput(
    @NotEmpty
    @Parameter(hidden = true)
    var id: String? = null,
    @NotEmpty
    val content: String? = null
)
