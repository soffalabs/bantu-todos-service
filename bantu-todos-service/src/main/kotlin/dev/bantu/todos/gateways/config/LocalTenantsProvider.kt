package dev.bantu.todos.gateways.config

import dev.bantu.accounts.api.operation.GetTenantList
import io.soffa.foundation.api.Operation
import io.soffa.foundation.data.TenantsLoader
import io.soffa.foundation.messages.BinaryClient
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class LocalTenantsProvider : TenantsLoader {

    override fun getTenantList(client: BinaryClient): Set<String> {
        val list = client.requestWithServiceToken("bantu-accounts", GetTenantList::class.java, Operation.NO_INPUT).get(30, TimeUnit.SECONDS)
        return list.tenants.toSet()
    }
}
