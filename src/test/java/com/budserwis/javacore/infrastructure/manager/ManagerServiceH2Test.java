package com.budserwis.javacore.infrastructure.manager;

import com.budserwis.javacore.JavacoreApplication;
import com.budserwis.javacore.domain.Category;
import com.budserwis.javacore.domain.Product;
import com.budserwis.javacore.domain.port.ProductRepository;
import com.budserwis.javacore.infrastructure.manager.config.H2TestJPAConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        JavacoreApplication.class,
        H2TestJPAConfig.class})
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ManagerServiceH2Test {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ManagerService service;


    @Test
    public void should_save_new_product_from_manager_panel() {
        //given
        var product = new Product("new product", "test-descr", 699L, "GARDEN");
        Long id = product.getId();
        System.out.println(id);

        //when
        service.saveNewProductToDB(product);

        //then
        assertThat(repository.findAll().size()).isGreaterThan(0);
        assertThat(repository.findById(id).get().getTitle()).isEqualTo("new product");
    }

}
