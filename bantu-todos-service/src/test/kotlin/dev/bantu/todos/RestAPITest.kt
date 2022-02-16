package dev.bantu.todos

import io.soffa.foundation.test.DatabaseTest
import io.soffa.foundation.test.HttpExpect
import io.soffa.foundation.tokens.TokenProvider
import io.soffa.foundation.tokens.TokenType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class RestAPITest : DatabaseTest() {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var tokens: TokenProvider

    @Test
    fun testAPI() {
        val test = HttpExpect(mvc)
        val token = tokens.create(
            TokenType.JWT, "app-0001", mapOf(
                "tenant" to "tx01"
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
                "tenant" to "tx02" // This tenant does not exist
            )
        )
        test.get("/v1").bearerAuth(token.value).expect().isBadRequest
    }

}
