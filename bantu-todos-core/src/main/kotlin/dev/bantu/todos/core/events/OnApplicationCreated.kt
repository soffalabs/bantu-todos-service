package dev.bantu.todos.core.events

import dev.bantu.accounts.api.Accounts
import dev.bantu.accounts.api.model.Application
import io.soffa.foundation.annotations.Handle
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.core.Operation
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.core.db.DB
import io.soffa.foundation.models.commons.Ack
import javax.inject.Named

@Named
@Handle(Accounts.APPLICATION_CREATED)
open class OnApplicationCreated(private val db: DB) : Operation<Application, Ack> {

    companion object {
        val LOG = Logger.get(OnApplicationCreated::class.java)!!
    }

    override fun handle(input: Application, context: RequestContext): Ack {
        val tenantId = input.id!!.value
        LOG.info("A new application [%s] was created, applying migrations", tenantId)
        db.applyMigrations(tenantId)
        db.applyMigrations("${tenantId}_test")
        return Ack.OK
    }

}
