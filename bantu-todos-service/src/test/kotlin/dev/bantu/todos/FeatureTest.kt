package dev.bantu.todos

import com.intuit.karate.junit5.Karate
import dev.bantu.accounts.Accounts
import io.soffa.foundation.core.db.DB
import io.soffa.foundation.core.security.TokenProvider
import io.soffa.foundation.models.TokenType
import org.awaitility.Awaitility
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import java.util.concurrent.TimeUnit


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FeatureTest {

    @LocalServerPort
    private val port = 0

    @Value("\${server.servlet.contextPath}")
    private var contextPath: String? = null

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
        return Karate.run(
            feature("actuator"),
            feature("nominal"),
        ).systemProperty("baseUrl", "http://localhost:$port$contextPath")
            .systemProperty("authToken", token.value)
    }

    @Karate.Test
    fun testErrors(): Karate {
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "permissions" to Accounts.APP_PERMISSION,
                "tenant" to "tx02" // This tenant does not exist
            )
        )
        return Karate.run(
            feature("errors"),
        ).systemProperty("baseUrl", "http://localhost:$port$contextPath")
            .systemProperty("authToken", token.value)
    }

    private fun feature(name: String) = "classpath:/feature/$name.feature"


}
