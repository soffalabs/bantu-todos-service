package dev.bantu.todos.api;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class ContractTest {

    @Test
    @Ignore
    public void testPojo() {
        Validator validator = ValidatorBuilder.create()
            .with(new SetterTester())
            .with(new GetterTester())
            .build();
        validator.validate("dev.bantu.todos.api.model", new FilterPackageInfo());

    }

}
