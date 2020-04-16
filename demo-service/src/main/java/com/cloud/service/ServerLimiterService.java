package com.cloud.service;

import com.cloud.entity.ServerLimiter;
import com.cloud.repository.ServerLimiterRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServerLimiterService {

    @Resource
    private ServerLimiterRepository serverLimiterRepository;

    public List<ServerLimiter> findAll() {
        return serverLimiterRepository.findAll();
    }
}
