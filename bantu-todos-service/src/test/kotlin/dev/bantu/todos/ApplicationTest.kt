package dev.bantu.todos

import io.soffa.foundation.test.HttpExpect
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApplicationTest  {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun testActuator() {
        val test = HttpExpect(mvc)
        test["/actuator/health"].expect().isOK.json("$.status", Matchers.equalTo("UP"))
    }
}
