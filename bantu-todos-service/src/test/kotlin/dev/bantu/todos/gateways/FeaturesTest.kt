package dev.bantu.todos.gateways

import com.intuit.karate.junit5.Karate
import dev.bantu.accounts.Accounts
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.models.TokenType
import dev.soffa.foundation.security.TokenProvider
import dev.soffa.foundation.test.karate.KarateTester
import org.awaitility.Awaitility
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import java.util.concurrent.TimeUnit


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FeaturesTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var tokens: TokenProvider

    @Autowired
    private lateinit var db: DB

    @BeforeEach
    fun prepare() {
        Awaitility.await().atMost(500, TimeUnit.MILLISECONDS).until {
            db.tenantExists("tx01")
        }
    }

    @Karate.Test
    fun testNominalScenarios(): Karate {
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "tenant" to "tx01",
                "permissions" to Accounts.APP_PERMISSION
            ), 30
        )
        return KarateTester.of(mockMvc).create(mapOf("authToken" to token.value), "todo.nominal")
    }


}
