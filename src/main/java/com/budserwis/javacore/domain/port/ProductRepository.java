package com.budserwis.javacore.domain.port;

import com.budserwis.javacore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* This repository connects with remote sql repository and manage all products information.
It @return Product object or list of products
* */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
