package com.application.repository;

import com.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
