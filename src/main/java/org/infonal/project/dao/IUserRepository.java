package org.infonal.project.dao;

import org.infonal.project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by heval on 15.08.2015.
 */

public interface IUserRepository extends MongoRepository<User,String> {
}
