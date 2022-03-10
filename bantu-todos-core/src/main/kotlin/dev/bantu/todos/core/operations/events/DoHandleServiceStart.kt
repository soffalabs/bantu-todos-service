package dev.bantu.todos.core.operations.events

import dev.bantu.accounts.Accounts
import dev.bantu.todos.App
import dev.soffa.foundation.context.Context
import dev.soffa.foundation.data.DB
import dev.soffa.foundation.events.OnServiceStarted
import dev.soffa.foundation.models.ServiceId
import javax.inject.Named

@Named
class DoHandleServiceStart(private val db: DB) : OnServiceStarted {

    override fun handle(input: ServiceId, context: Context): Void? {
        if (input.value == Accounts.ID) {
            App.Log.info("Accounts service started, updated local schema.")
            db.configureTenantsAsync()
        }
        return null
    }

}
