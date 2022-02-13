package dev.bantu.todos.gateways.config

import dev.bantu.accounts.api.operation.GetTenantList
import io.soffa.foundation.data.TenantsLoader
import io.soffa.foundation.messages.BinaryClient
import org.springframework.stereotype.Component

@Component
class LocalTenantsProvider(private val client: BinaryClient) : TenantsLoader {

    override fun getTenantList(): Set<String> {
        val list = client.request("bantu-accounts", GetTenantList::class.java).get()
        return list.tenants.toSet()
    }
}
