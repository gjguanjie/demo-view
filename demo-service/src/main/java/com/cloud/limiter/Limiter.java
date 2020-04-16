package com.cloud.limiter;

import com.cloud.entity.ServerLimiter;
import com.cloud.service.ServerLimiterService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
@Component
public class Limiter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final int CAPACITY_SIZE = 1000;
    private static final int LIMIT_TIME = 1000;
    private static Cache<String, RateLimiter> cache = CacheBuilder.newBuilder()
            .initialCapacity(CAPACITY_SIZE).expireAfterAccess(1, TimeUnit.MINUTES)
            .build();

    private static Map<String,Integer>  serviceLimiter = new ConcurrentHashMap<>();

    @Resource
    private ServerLimiterService serverLimiterService;

    @PostConstruct
    public void init() {
        List<ServerLimiter> serverLimiters =  serverLimiterService.findAll();
        serverLimiters.stream().forEach(limit -> serviceLimiter.put(limit.getServiceName(),limit.getLimitCount()));
        System.out.println(serverLimiters.size());
    }

    public static boolean isLimit(String accessKeyID) {
        RateLimiter rateLimiter = null;
        try {
            Integer limit = serviceLimiter.get(accessKeyID) != null ? serviceLimiter.get(accessKeyID) : 10;
            rateLimiter = cache.get(accessKeyID, new Callable<RateLimiter>() {
                @Override
                public RateLimiter call() throws Exception {
                    return RateLimiter.create(limit);
                }
            });
        } catch (ExecutionException e) {
            LOGGER.error("create limit fail", e);
        }
        if (rateLimiter != null && !rateLimiter.tryAcquire(LIMIT_TIME, TimeUnit.MILLISECONDS)) {
            LOGGER.error("access_key_id:{} limited", accessKeyID);
            return true;
        }
        LOGGER.error("access_key_id:{} pass", accessKeyID);
        return false;
    }

}
