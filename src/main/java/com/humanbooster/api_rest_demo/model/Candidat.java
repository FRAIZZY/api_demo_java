/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.api_rest_demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "candidat")
public class Candidat {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "mail", nullable = false, length = 250)
    @Length(max = 250, min = 1, message = "Le mail doit contenir entre 1 et 250 caracteres")
    @NotNull(message = "Le mail ne peut pas etre null")
    @NotBlank(message = "Le mail ne peut pas etre vide")
    private String mail;

    @Basic
    @Column(name = "password", nullable = false, length = 250)
    @Length(max = 250, min = 1, message = "Le password doit contenir entre 1 et 250 caracteres")
    @NotNull(message = "Le password ne peut pas etre null")
    @NotBlank(message = "Le password ne peut pas etre vide")
    private String password;

    @Basic
    @Column(name = "lastname", nullable = false, length = 250)
    @Length(max = 250, min = 1, message = "Le nom doit contenir entre 1 et 250 caracteres")
    @NotNull(message = "Le nom ne peut pas etre null")
    @NotBlank(message = "Le nom ne peut pas etre vide")
    private String lastname;

    @Basic
    @Column(name = "firstname", nullable = false, length = 250)
    @Length(max = 250, min = 1, message = "Le prenom doit contenir entre 1 et 250 caracteres")
    @NotNull(message = "Le prenom ne peut pas etre null")
    @NotBlank(message = "Le prenom ne peut pas etre vide")
    private String firstname;

    public Candidat() {

    }

    public Candidat(String mail, String password, String lastname, String firstname) {
        this.mail = mail;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Candidat{" + "id=" + id + ", mail=" + mail + ", password=" + password + ", lastname=" + lastname + ", firstname=" + firstname + '}';
    }

}
