package dev.bantu.todos.api.operation

import dev.bantu.todos.api.schema.Todo
import dev.soffa.foundation.core.Operation

interface CompleteTodo: Operation<String, Todo>
