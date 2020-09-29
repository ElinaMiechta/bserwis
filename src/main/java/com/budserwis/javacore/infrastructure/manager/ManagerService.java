package com.budserwis.javacore.infrastructure.manager;

import com.budserwis.javacore.domain.exception.UserDoesNotExist;
import com.budserwis.javacore.infrastructure.manager.dao.ManagerRepository;
import com.budserwis.javacore.infrastructure.manager.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ManagerService {
    private ManagerRepository repository;

    @Autowired
    public ManagerService(ManagerRepository repository) {
        this.repository = repository;
    }

    public Manager verifyManager(String username, String password) throws UserDoesNotExist {
        var manager = repository.findByUsernameAndPassword(username, password);
        if (manager.isPresent()) {
            return manager.get();
        }else{
            throw new UserDoesNotExist();
        }
    }

    public List<Manager> findAll() {
        return repository.findAll();
    }
}
