package dev.bantu.todos.gateways.config

import dev.bantu.accounts.api.Accounts
import dev.bantu.accounts.api.operation.GetTenantList
import io.soffa.foundation.core.AppConfig
import io.soffa.foundation.core.context.DefaultRequestContext
import io.soffa.foundation.core.security.TokenProvider
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.core.TenantsLoader
import io.soffa.foundation.core.pubsub.PubSubClientFactory
import io.soffa.foundation.core.pubsub.PubSubMessenger
import io.soffa.foundation.models.TokenType
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
        val operation = PubSubClientFactory.of(GetTenantList::class.java, Accounts.ID, client)
        return try {
            val token = tokens.create(TokenType.JWT, app.name, mapOf("permissions" to "service")).value
            val context = DefaultRequestContext().withAuthorization("Bearer $token")
            val res = operation.handle(null, context) ?: return emptySet()
            return res.tenants.toSet()
        } catch (e: Exception) {
            logger.error("Unable to fetch tenants list from bantu-accounts, make sure the service is reachable", e)
            emptySet()
        }
    }
}
