package com.amir.DBSpring;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private String email;
    private String password;

}
