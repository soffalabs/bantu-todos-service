package dev.bantu.todos.core.operation

import dev.bantu.accounts.api.model.CreateApplicationOutput
import io.soffa.foundation.api.Operation

interface HandleApplicationCreated: Operation<CreateApplicationOutput, Unit> {
}
