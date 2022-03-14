package dev.bantu.todos.api.schema

import io.swagger.v3.oas.annotations.Hidden
import javax.validation.constraints.NotEmpty

data class UpdateTodoInput(
    @Hidden
    var id: String? = null,
    @get:NotEmpty
    var content: String? = null
)
