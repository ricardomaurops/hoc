package br.com.rmservicos.hoc.entities;

import br.com.rmservicos.hoc.enums.UserProfile;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    private Date dtIncl;
    private Date dtAlter;
    private Date dtInat;

    private UserProfile userProfile;

}
