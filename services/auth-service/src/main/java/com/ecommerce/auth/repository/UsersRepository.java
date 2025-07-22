package com.ecommerce.auth.repository;

import com.ecommerce.auth.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Users u WHERE u.email = :email AND u.name = :name AND u.googleId = :googleId")
    boolean isUserExist (@Param("email") String email, @Param("name") String name, @Param("googleId") String googleId);

    @Query(value = "INSERT INTO Users (email, name, googleId) VALUES (:email, :name, :googleId)", nativeQuery = true)
    @Modifying
    void recordUser (@Param("email") String email, @Param("name") String name, @Param("googleId") String googleId);

}
