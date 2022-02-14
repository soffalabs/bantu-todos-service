package dev.bantu.todos.gateways.config

import dev.bantu.accounts.api.AccountClient
import dev.bantu.accounts.api.operation.GetTenantList
import io.soffa.foundation.api.Operation
import io.soffa.foundation.context.RequestContextHolder
import io.soffa.foundation.data.TenantsLoader
import io.soffa.foundation.messages.PubSubClient
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class LocalTenantsProvider(
    private val client: PubSubClient
) : TenantsLoader {

    override fun getTenantList(): Set<String> {
        val res = client.request(
            AccountClient.ID,
            GetTenantList::class.java,
            Operation.NO_INPUT,
            RequestContextHolder.getOrCreate().withServiceToken()
        ).get(5, TimeUnit.MINUTES)
        return res.tenants.toSet()
    }
}
