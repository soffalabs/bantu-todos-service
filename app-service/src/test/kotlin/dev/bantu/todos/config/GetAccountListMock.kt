package dev.bantu.todos.config

import dev.soffa.foundation.annotation.Handle
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.core.Operation
import dev.soffa.foundation.model.TenantList
import javax.inject.Named

@Named
@Handle("GetTenantList")
class GetAccountListMock : Operation<Void, TenantList> {

    override fun handle(input: Void?, context: Context): TenantList {
        return TenantList(setOf("tx01"))
    }
}
