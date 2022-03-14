package dev.bantu.todos.core.handler

import dev.bantu.accounts.Accounts
import dev.bantu.todos.Globals.Log
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.events.OnServiceStarted
import dev.soffa.foundation.model.ServiceId
import javax.inject.Named

@Named
class HandleServiceStart(private val db: DB) : OnServiceStarted {

    override fun handle(input: ServiceId, context: Context): Void? {
        if (input.value == Accounts.ID) {
            Log.info("Accounts service started, updated local schema.")
            db.configureTenantsAsync()
            context.sideEffect("locaL_schema_updated")
        }
        return null
    }

}
