package com.cloud.filter;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FirstFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Override
    public boolean postprocess(Context context, Exception e) {
        LOGGER.error("过滤器后处理器");
        return false;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        LOGGER.error("过滤器执行，{}",context.get("参数名"));
        return false;
    }
}
