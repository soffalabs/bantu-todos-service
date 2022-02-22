package dev.bantu.todos

import dev.bantu.accounts.api.Accounts
import dev.bantu.accounts.api.model.Application
import dev.bantu.accounts.api.model.ApplicationId
import io.soffa.foundation.core.context.DefaultRequestContext
import io.soffa.foundation.core.db.DB
import io.soffa.foundation.core.messages.Message
import io.soffa.foundation.core.pubsub.MessageHandler
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test", "foundation-pubsub")
class AccountEventTests {

    @Autowired
    private lateinit var messenger: MessageHandler

    @Autowired
    private lateinit var db: DB

    @Test
    fun testApplicationCreatedEvent() {
        val msg = Message(
            Accounts.APPLICATION_CREATED,
            Application(id = ApplicationId("app02")),
            DefaultRequestContext()
        )
        messenger.handle(msg)
        assertTrue(db.tenantExists("app02"))
    }
}
