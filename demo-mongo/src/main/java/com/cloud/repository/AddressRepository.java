package com.cloud.repository;

import com.cloud.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,Long> {

}
