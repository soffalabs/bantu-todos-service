package dev.bantu.todos

import dev.bantu.accounts.api.Messages
import dev.bantu.accounts.api.model.Application
import dev.bantu.accounts.api.model.ApplicationId
import dev.bantu.accounts.api.model.CreateApplicationOutput
import io.soffa.foundation.context.RequestContext
import io.soffa.foundation.data.DB
import io.soffa.foundation.messages.Message
import io.soffa.foundation.messages.MessageHandler
import io.soffa.foundation.test.DatabaseTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AccountEventTests : DatabaseTest() {

    @Autowired
    private lateinit var messenger: MessageHandler

    @Autowired
    private lateinit var db: DB

    @Test
    fun testApplicationCreatedEvent() {
        val msg = Message(
            Messages.APPLICATION_CREATED,
            CreateApplicationOutput(Application(id = ApplicationId("app02"))),
            RequestContext()
        )
        messenger.handle(msg)
        assertTrue(db.tenantExists("app02"))
    }
}
