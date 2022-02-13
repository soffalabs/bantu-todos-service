package dev.bantu.todos

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.ActiveProfiles
import io.soffa.foundation.test.DatabaseTest
import org.springframework.test.web.servlet.MockMvc
import io.soffa.foundation.test.HttpExpect
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApplicationTest : DatabaseTest() {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun testActuator() {
        val test = HttpExpect(mvc)
        test["/actuator/health"].expect().isOK.json("$.status", Matchers.equalTo("UP"))
    }
}
