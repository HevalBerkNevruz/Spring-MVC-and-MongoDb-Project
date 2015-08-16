package org.infonal.project.service;

import org.infonal.project.model.User;

import java.util.List;

/**
 * Created by heval on 15.08.2015.
 */
public interface IUserService {
    public void addUser(User user);

    public void deleteUser(String id);

    public User getUser(String id);

    public List<User> getAllUser();
}
