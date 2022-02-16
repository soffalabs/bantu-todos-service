package dev.bantu.todos.api

import com.openpojo.validation.ValidatorBuilder
import com.openpojo.validation.test.impl.SetterTester
import com.openpojo.validation.test.impl.GetterTester
import com.openpojo.reflection.filters.FilterPackageInfo
import org.junit.jupiter.api.Test

class ContractTest {

    @Test
    fun testPojo() {
        val validator = ValidatorBuilder.create()
            .with(SetterTester())
            .with(GetterTester())
            .build()
        validator.validate("dev.bantu.todos.api.model", FilterPackageInfo())
    }
}
