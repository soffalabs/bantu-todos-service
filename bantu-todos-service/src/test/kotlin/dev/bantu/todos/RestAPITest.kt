package dev.bantu.todos

import io.soffa.foundation.data.DB
import io.soffa.foundation.security.TokenProvider
import io.soffa.foundation.security.model.TokenType
import io.soffa.foundation.test.HttpExpect
import org.awaitility.Awaitility
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import java.util.concurrent.TimeUnit

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class RestAPITest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var tokens: TokenProvider

    @Autowired
    private lateinit var db: DB

    @BeforeEach
    fun prepare() {
        Awaitility.await().atMost(2, TimeUnit.SECONDS).until {
            db.tenantExists("tx01")
        }
    }

    @Test
    fun testAPI() {
        val test = HttpExpect(mvc)
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "tenant" to "tx01",
                "permissions" to "application"
            )
        )
        test.get("/v1").bearerAuth(token.value).expect().isOK

        test.post("/v1").withJson(mapOf(
            "content" to "Release bantu-todos"
        )).bearerAuth(token.value).expect().isOK.hasJson("$.id")

        test.get("/v1").bearerAuth(token.value).expect().isOK.hasJson("$[0].id")
    }

    @Test
    fun testInvalidData() {
        val test = HttpExpect(mvc)
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "permissions" to "application",
                "tenant" to "tx02" // This tenant does not exist
            )
        )
        test.get("/v1").bearerAuth(token.value).expect().isBadRequest
    }

}
