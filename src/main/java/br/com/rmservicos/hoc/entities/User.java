package br.com.rmservicos.hoc.entities;

import br.com.rmservicos.hoc.enums.UserProfile;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    private Date dtIncl;
    private Date dtAlter;
    private Date dtInat;

    private UserProfile userProfile;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtIncl() {
        return dtIncl;
    }

    public void setDtIncl(Date dtIncl) {
        this.dtIncl = dtIncl;
    }

    public Date getDtAlter() {
        return dtAlter;
    }

    public void setDtAlter(Date dtAlter) {
        this.dtAlter = dtAlter;
    }

    public Date getDtInat() {
        return dtInat;
    }

    public void setDtInat(Date dtInat) {
        this.dtInat = dtInat;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
