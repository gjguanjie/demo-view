package com.cloud;

import com.cloud.command.FirstCommand;
import com.cloud.command.SecondCommand;
import com.cloud.filter.FirstFilter;
import org.apache.commons.chain.Chain;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class TestTests {

    @Test
    void contextLoads() throws Exception {
        Context context = new ContextBase();
        context.put("参数名","参数值");
        Chain chain = new ChainBase();
        chain.addCommand(new FirstCommand());
        chain.addCommand(new SecondCommand());
        chain.addCommand(new FirstFilter());
        chain.execute(context);
    }

}
