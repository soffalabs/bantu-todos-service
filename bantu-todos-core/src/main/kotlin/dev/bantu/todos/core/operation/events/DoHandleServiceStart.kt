package dev.bantu.todos.core.operation.events

import dev.bantu.accounts.Accounts
import dev.bantu.todos.core.App
import io.soffa.foundation.core.RequestContext
import io.soffa.foundation.core.data.DB
import io.soffa.foundation.core.events.OnServiceStarted
import io.soffa.foundation.core.events.ServiceInfo
import javax.inject.Named

@Named
class DoHandleServiceStart(private val db: DB) : OnServiceStarted {

    override fun handle(input: ServiceInfo, context: RequestContext): Void? {
        if (input.serviceId == Accounts.ID) {
            App.Log.info("Accounts service started, updated local schema.")
            db.configureTenantsAsync()
        }
        return null
    }

}
