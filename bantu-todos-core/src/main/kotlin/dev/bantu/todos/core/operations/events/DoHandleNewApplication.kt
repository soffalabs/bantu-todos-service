package dev.bantu.todos.core.operations.events

import dev.bantu.accounts.Accounts
import dev.bantu.accounts.api.events.OnApplicationCreated
import dev.bantu.accounts.api.schema.Application
import dev.soffa.foundation.annotations.Handle
import dev.soffa.foundation.commons.Logger
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import javax.inject.Named

@Named
@Handle(Accounts.APPLICATION_CREATED)
class DoHandleNewApplication(private val db: DB) : OnApplicationCreated {

    companion object {
        val LOG = Logger.get(DoHandleNewApplication::class.java)!!
    }

    override fun handle(input: Application, context: Context) {
        val tenantId = input.id!!.value
        LOG.info("A new application [%s] was created, registering local datasources", tenantId)
        db.register(arrayOf(tenantId, "${tenantId}_test"), true)
    }

}
