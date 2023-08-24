package com.tc.PlantNursery.repository;

import com.tc.PlantNursery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findUserByEmail(String username);
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    List<User> findByRole(String role);
}
