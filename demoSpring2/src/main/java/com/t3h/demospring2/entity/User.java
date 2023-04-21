package com.t3h.demospring2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String fullName;
    private String address;
    private int age;
    private String userName;
    private String password;
    private int roleId;
}
