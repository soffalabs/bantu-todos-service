package dev.bantu.todos.api.schema

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

enum class TodoStatus(@get:JsonValue @get:JsonCreator var value: String) {
    @JsonProperty("pending")
    PENDING("pending"),
    @JsonProperty("done")
    DONE("done")
}
