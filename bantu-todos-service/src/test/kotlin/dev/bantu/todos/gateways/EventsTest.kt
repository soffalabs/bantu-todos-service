package dev.bantu.todos.gateways

import dev.bantu.accounts.Accounts
import dev.bantu.accounts.api.schema.Application
import dev.bantu.accounts.api.schema.ApplicationId
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.messages.Message
import dev.soffa.foundation.messages.MessageHandler
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test", "foundation-pubsub")
class EventsTest {

    @Autowired
    private lateinit var messenger: MessageHandler

    @Autowired
    private lateinit var db: DB

    @Test
    fun testApplicationCreatedEvent() {
        val msg = Message(
            Accounts.APPLICATION_CREATED,
            Application(id = ApplicationId("app02")),
            Context()
        )
        messenger.handle(msg)
        assertTrue(db.tenantExists("app02"))
    }
}
