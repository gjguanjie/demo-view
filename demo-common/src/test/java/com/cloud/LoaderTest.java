package com.cloud;

import com.cloud.loader.ILoader;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class LoaderTest {

    @Test
    public void test() {
        ServiceLoader<ILoader> serviceLoader = ServiceLoader.load(ILoader.class);
        Iterator iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            ILoader iLoader = (ILoader) iterator.next();
            iLoader.print();
        }
    }
}
