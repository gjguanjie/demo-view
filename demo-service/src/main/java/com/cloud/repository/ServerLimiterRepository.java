package com.cloud.repository;

import com.cloud.entity.ServerLimiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerLimiterRepository extends JpaRepository<ServerLimiter,Long> {
}
