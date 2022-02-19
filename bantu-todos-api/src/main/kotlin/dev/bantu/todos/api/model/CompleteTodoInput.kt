package dev.bantu.todos.api.model

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import javax.validation.constraints.NotEmpty

data class CompleteTodoInput(
    @NotEmpty
    @Parameter(`in` = ParameterIn.PATH)
    val id: String? = null
)
