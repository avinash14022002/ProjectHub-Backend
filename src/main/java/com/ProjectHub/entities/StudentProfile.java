package com.ProjectHub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Avinash Vijayvargiya on 30-09-2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentsuserdetails")
public class StudentProfile implements Serializable {

    private static final long serialVersionUID = 2364534L;
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "department")
    private String department;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "roles")
    private String roles;

    //    Projects

    @Column(name = "project1id", nullable = false)
    private Long project1id;

    @Column(name = "project2id", nullable = false)
    private Long project2id;

    @Column(name = "project3id", nullable = false)
    private Long project3id;

    @Column(name = "project4id", nullable = false)
    private Long project4id;

    @Column(name = "project5id", nullable = false)
    private Long project5id;

    @Column(name = "project6id", nullable = false)
    private Long project6id;

    @Column(name = "project7id", nullable = false)
    private Long project7id;

    @Column(name = "project8id", nullable = false)
    private Long project8id;

    //    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
    public boolean isActive() {
        return true;
    }
//
//    public String getRoles() {
//        return roles;
//    }
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}

