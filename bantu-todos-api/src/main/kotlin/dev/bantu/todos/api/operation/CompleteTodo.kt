package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.CompleteTodoInput
import dev.bantu.todos.api.model.Todo
import io.soffa.foundation.api.Operation

interface CompleteTodo: Operation<CompleteTodoInput, Todo>
