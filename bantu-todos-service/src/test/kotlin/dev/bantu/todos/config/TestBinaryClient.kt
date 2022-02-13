package dev.bantu.todos.config

import dev.bantu.accounts.api.model.TenantList
import io.soffa.foundation.messages.AbstractBinaryClient
import io.soffa.foundation.messages.Message
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class TestBinaryClient : AbstractBinaryClient() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> request(subject: String?, event: Message?, expectedClass: Class<T>): CompletableFuture<T> {
        if (expectedClass == TenantList::class.java) {
            return CompletableFuture.supplyAsync { TenantList(arrayListOf("tx01")) as T }
        }
        TODO("Not yet implemented")
    }
}
