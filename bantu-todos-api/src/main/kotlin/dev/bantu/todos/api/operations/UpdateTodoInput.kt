package dev.bantu.todos.api.operations

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import javax.validation.constraints.NotEmpty

data class UpdateTodoInput(
    @NotEmpty
    @Parameter(`in` = ParameterIn.PATH)
    var id: String? = null,
    @NotEmpty
    @Parameter(`in` = ParameterIn.DEFAULT)
    val content: String? = null
)
