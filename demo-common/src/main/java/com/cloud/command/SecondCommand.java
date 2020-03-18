package com.cloud.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SecondCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Override
    public boolean execute(Context context) throws Exception {

        LOGGER.error("第二个命令，{}",context.get("参数名"));
        return false;
    }
}
