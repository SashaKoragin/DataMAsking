package com.example.DataMasking.Repository;

import com.example.DataMasking.DataBaseEntity.User;

import org.jooq.DSLContext;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}