package dev.bantu.todos.api.operation

import dev.bantu.todos.api.model.TodoList
import io.soffa.foundation.api.Operation

interface GetTodoList : Operation<Void, TodoList>
