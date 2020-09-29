package com.budserwis.javacore.infrastructure.manager.dao;


import com.budserwis.javacore.infrastructure.manager.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByUsernameAndPassword(String username, String password);
}
