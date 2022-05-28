package com.pfe.elios.Repositories;

import com.pfe.elios.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);

    Optional<Object> findUserById(Long id);
    void deleteUserById(Long id);



}
