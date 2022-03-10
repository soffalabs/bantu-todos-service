package dev.bantu.todos.gateways.config

import dev.soffa.foundation.annotations.Handle
import dev.soffa.foundation.core.Operation
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.models.TenantList
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Handle("GetTenantList")
@Primary
class GetAccountListMock : Operation<Void, TenantList> {

    override fun handle(input: Void?, context: Context): TenantList {
        return TenantList(setOf("tx01"))
    }
}
