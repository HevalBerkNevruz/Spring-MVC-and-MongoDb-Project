package org.infonal.project;

import org.infonal.project.config.MvcConfiguration;
import org.infonal.project.dao.IUserRepository;
import org.infonal.project.model.User;
import org.infonal.project.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by heval on 24.08.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = MvcConfiguration.class)
public class UserServiceTest {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    IUserRepository repository;

    @Before
    public void setup() {
        service.setRepository(repository);
        repository.deleteAll();
    }

    @Rollback(true)
    @Test
    public void testAddUser() throws Exception {
        User user = new User("11", "Heval Berk", "Nevruz", 123);
        service.addUser(user);
        assertNotNull(service.getUser(user.getId()));
    }

    @Rollback(true)
    @Test
    public void testDeleteUser() throws Exception {
        User user = new User("11", "Heval Berk", "Nevruz", 123);
        service.addUser(user);
        service.deleteUser(user.getId());
        assertNull(service.getUser(user.getId()));
    }

    @Rollback(true)
    @Test
    public void testGetAllUserForOneUser() throws Exception {
        User user = new User("11", "Heval Berk", "Nevruz", 123);
        service.addUser(user);
        List<User> userList=service.getAllUser();
        assertEquals(userList.size(), 1);
    }

    @Rollback(true)
    @Test
    public void testGetAllUserForTwoUser() throws Exception{
        User user1 = new User("11", "Heval Berk", "Nevruz", 123);
        User user2 = new User("12", "Heval Berk", "Nevruz", 123);
        service.addUser(user1);
        service.addUser(user2);
        List<User> userList=service.getAllUser();
        assertEquals(userList.size(), 2);
    }
}
