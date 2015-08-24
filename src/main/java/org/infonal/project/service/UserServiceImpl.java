package org.infonal.project.service;

import org.infonal.project.dao.IUserRepository;
import org.infonal.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heval on 15.08.2015.
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    public void setRepository(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        repository.delete(id);
    }

    @Override
    public User getUser(String id) {
        User user=repository.findOne(id);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }
}
