package com.linuxtips.jwtrefreshtoken.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "refreshtoken")
@Setter
@Getter
@ToString
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Date expirationTime;

    public RefreshToken() {
    }

}
