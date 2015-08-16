package org.infonal.project.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by heval on 14.08.2015.
 */

@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String userName;
    private String userSurname;
    private int telephoneNumber;

    public User() {

    }

    public User(String id, String userName, String userSurname, int telephoneNumber) {
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.telephoneNumber = telephoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
