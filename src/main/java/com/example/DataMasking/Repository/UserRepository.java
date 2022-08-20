package com.example.DataMasking.Repository;

import com.example.DataMasking.CustomPhysicalNamingStrategy.DataBaseEntity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {
}