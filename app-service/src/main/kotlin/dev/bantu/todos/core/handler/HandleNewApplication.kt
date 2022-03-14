package dev.bantu.todos.core.handler

import dev.bantu.accounts.Accounts
import dev.bantu.accounts.api.event.OnApplicationCreated
import dev.bantu.accounts.api.schema.Application
import dev.bantu.todos.Globals.Log
import dev.soffa.foundation.annotation.Handle
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import javax.inject.Named

@Named
@Handle(Accounts.APPLICATION_CREATED)
class HandleNewApplication(private val db: DB) : OnApplicationCreated {

    override fun handle(input: Application, ctx: Context) {
        val tenantId = input.id!!.value
        Log.info("A new application [%s] was created, registering local datasources", tenantId)
        db.register(arrayOf(tenantId, "${tenantId}_test"), true)
        ctx.sideEffect("datasource_registered")
    }

}
