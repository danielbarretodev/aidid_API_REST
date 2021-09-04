package com.aidid.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="username")
    private String username;
  
    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;
    
    @Column(name="dtype", insertable=false, updatable=false)
    private String dType;
  
}
