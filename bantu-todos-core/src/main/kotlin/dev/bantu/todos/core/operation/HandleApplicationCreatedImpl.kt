package dev.bantu.todos.core.operation

import dev.bantu.accounts.api.model.CreateApplicationOutput
import io.soffa.foundation.annotations.Handle
import io.soffa.foundation.commons.Logger
import io.soffa.foundation.context.RequestContext
import io.soffa.foundation.data.DB
import javax.inject.Named

@Named
@Handle(dev.bantu.accounts.api.Messages.APPLICATION_CREATED)
class HandleApplicationCreatedImpl(private val ds: DB) : HandleApplicationCreated {

    companion object {
        val LOG = Logger.get(HandleApplicationCreatedImpl::class.java)!!
    }

    override fun handle(input: CreateApplicationOutput, context: RequestContext) {
        val tenantId = input.application!!.id!!.value
        LOG.info("A new application [%s] was created, applying migrations", tenantId)
        ds.applyMigrations(tenantId)
    }

}
