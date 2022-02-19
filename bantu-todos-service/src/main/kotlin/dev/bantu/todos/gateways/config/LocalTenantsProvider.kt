package dev.bantu.todos.gateways.config

import dev.bantu.accounts.api.AccountClient
import dev.bantu.accounts.api.operation.GetTenantList
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.config.AppConfig
import io.soffa.foundation.context.RequestContext
import io.soffa.foundation.data.TenantsLoader
import io.soffa.foundation.pubsub.PubSubMessenger
import io.soffa.foundation.security.TokenProvider
import io.soffa.foundation.security.model.TokenType
import org.springframework.stereotype.Component

@Component
class LocalTenantsProvider(
    private val client: PubSubMessenger,
    private val tokens: TokenProvider,
    private val app: AppConfig
) : TenantsLoader {

    companion object {
        val logger = Logger.get(LocalTenantsProvider::class.java)!!
    }

    override fun getTenantList(): Set<String> {
        val operation = client.proxy(AccountClient.ID, GetTenantList::class.java);
        return try {
            val token = tokens.create(TokenType.JWT, app.name, mapOf("permissions" to "service")).value
            val context = RequestContext().withAuthorization("Bearer $token")
            val res = operation.handle(null, context) ?: return emptySet()
            return res.tenants.toSet()
        } catch (e: Exception) {
            logger.error("Unable to fetch tenants list from bantu-accounts, make sure the service is reachable", e)
            emptySet()
        }
    }
}
