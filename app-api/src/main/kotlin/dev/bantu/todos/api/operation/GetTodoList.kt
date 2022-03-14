package dev.bantu.todos.api.operation

import dev.bantu.todos.api.schema.TodoList
import dev.soffa.foundation.core.Operation

interface GetTodoList : Operation<Void?, TodoList>
