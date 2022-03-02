package dev.bantu.todos.core.operation.events

import dev.bantu.accounts.Accounts
import dev.bantu.accounts.api.events.OnApplicationCreated
import dev.bantu.accounts.api.models.Application
import io.soffa.foundation.annotations.Handle
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.core.db.DB
import javax.inject.Named

@Named
@Handle(Accounts.APPLICATION_CREATED)
class DoHandleNewApplication(private val db: DB) : OnApplicationCreated {

    companion object {
        val LOG = Logger.get(DoHandleNewApplication::class.java)!!
    }

    override fun handle(input: Application, context: RequestContext) {
        val tenantId = input.id!!.value
        LOG.info("A new application [%s] was created, registering local datasources", tenantId)
        db.register(arrayOf(tenantId, "${tenantId}_test"), true)
    }

}
