package com.budserwis.javacore.infrastructure.manager;

import com.budserwis.javacore.domain.Product;
import com.budserwis.javacore.domain.exception.UserDoesNotExist;
import com.budserwis.javacore.domain.port.ProductRepository;
import com.budserwis.javacore.infrastructure.manager.dao.ManagerRepository;
import com.budserwis.javacore.infrastructure.manager.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ManagerRepository repository;

    public Manager verifyManager(String username, String password) throws UserDoesNotExist {
        var manager = repository.findByUsernameAndPassword(username, password);
        if (manager.isPresent()) {
            return manager.get();
        } else {
            throw new UserDoesNotExist();
        }
    }

    public void saveNewProductToDB(Product product) {
        if (product != null) {
            productRepository.save(product);
        }
    }
}
