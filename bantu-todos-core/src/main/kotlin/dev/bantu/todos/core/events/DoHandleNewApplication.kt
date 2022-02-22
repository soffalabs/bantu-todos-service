package dev.bantu.todos.core.events

import dev.bantu.accounts.api.Accounts
import dev.bantu.accounts.api.model.Application
import dev.bantu.accounts.api.operation.events.OnApplicationCreated
import io.soffa.foundation.annotations.Handle
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.core.db.DB
import javax.inject.Named

@Named
@Handle(Accounts.APPLICATION_CREATED)
open class DoHandleNewApplication(private val db: DB) : OnApplicationCreated {

    companion object {
        val LOG = Logger.get(DoHandleNewApplication::class.java)!!
    }

    override fun handle(input: Application, context: RequestContext) {
        val tenantId = input.id!!.value
        LOG.info("A new application [%s] was created, applying migrations", tenantId)
        db.applyMigrations(tenantId)
        db.applyMigrations("${tenantId}_test")
    }

}
