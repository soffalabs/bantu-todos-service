package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.CompleteTodoInput
import dev.bantu.todos.api.model.Todo
import io.soffa.foundation.core.Operation

interface CompleteTodo: Operation<CompleteTodoInput, Todo>
