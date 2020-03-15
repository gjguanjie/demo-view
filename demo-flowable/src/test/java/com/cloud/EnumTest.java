package com.cloud;

import com.cloud.constants.AssignNodeConstants;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class EnumTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testEnum() {
        LOGGER.error("所有枚举值：{}",AssignNodeConstants.getNames());
    }
}
