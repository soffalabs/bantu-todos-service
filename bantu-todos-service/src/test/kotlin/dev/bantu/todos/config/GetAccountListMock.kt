package dev.bantu.todos.config

import dev.bantu.accounts.api.model.TenantList
import io.soffa.foundation.annotations.Handle
import io.soffa.foundation.api.Operation
import io.soffa.foundation.context.RequestContext
import org.springframework.stereotype.Component

@Component
@Handle("GetTenantList")
class GetAccountListMock : Operation<Void, TenantList> {

    override fun handle(input: Void?, context: RequestContext): TenantList {
        return TenantList(setOf("tx01"))
    }
}
