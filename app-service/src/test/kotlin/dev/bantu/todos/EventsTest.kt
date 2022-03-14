package dev.bantu.todos

import dev.bantu.accounts.Accounts
import dev.bantu.accounts.api.schema.Application
import dev.bantu.accounts.api.schema.ApplicationId
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.events.OnServiceStarted
import dev.soffa.foundation.message.Message
import dev.soffa.foundation.model.ServiceId
import dev.soffa.foundation.test.BaseMessageTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import javax.inject.Inject
import kotlin.test.assertFalse

class EventsTest: BaseMessageTest() {

    @Inject
    private lateinit var db: DB

    @Inject
    private lateinit var onSserviceStarted: OnServiceStarted

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

    @Test
    fun testOnServiceStarted() {
        val ctx = Context()
        onSserviceStarted.handle(ServiceId("foo"), ctx)
        assertTrue(ctx.sideEffects.isEmpty)

        onSserviceStarted.handle(ServiceId(Accounts.ID), ctx)
        assertFalse(ctx.sideEffects.isEmpty)
    }
}
