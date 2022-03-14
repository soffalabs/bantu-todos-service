package dev.bantu.todos

import dev.bantu.accounts.Accounts
import dev.soffa.foundation.model.TokenType
import dev.soffa.foundation.security.TokenProvider
import dev.soffa.foundation.test.BaseFeatureTest
import javax.inject.Inject


class FeaturesTest : BaseFeatureTest() {

    @Inject
    private lateinit var tokens: TokenProvider

    override fun getFeatures() = arrayOf("todo.nominal")

    override fun getTestData(): Map<String, Any> {
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "tenant" to "tx01",
                "permissions" to Accounts.APP_PERMISSION
            ), 30
        )
        return mapOf("authToken" to token.value)
    }


}
