package com.budserwis.javacore.infrastructure.manager;

import com.budserwis.javacore.domain.exception.UserDoesNotExist;
import com.budserwis.javacore.infrastructure.manager.dao.ManagerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceTest {
    @Autowired
    private ManagerService service;

    @Autowired
    private ManagerRepository repository;


    @Test
    public void shouldGetInitializeManagerAfterConnectingTheDB() {

        //then
        assertThat(repository.findAll().size()).isGreaterThan(0);
        assertThat(repository.findAll().size()).isEqualTo(1);
    }

    @Test
    public void should_verify_Manager() throws UserDoesNotExist {
        service.verifyManager("mechtaelina@gmail.com", "Administrator123");
    }

    @Test(expected = UserDoesNotExist.class)
    public void should_not_verify_Manager() throws UserDoesNotExist {
        service.verifyManager("mechta@gmail.com", "Admin123");
    }

}