package com.example.demo.security.repositories;

import com.example.demo.security.entities.User;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    User findUserByUserId(Long userId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_roles (user_id,role_id) VALUES (:user_id, :rol_id)", nativeQuery = true)
    Integer addUserRole(@Param("user_id") Long user_id,@Param("rol_id") Long rol_Id);

}
