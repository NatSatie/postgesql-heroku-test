package com.example.postgesqlherokutest.model;

import com.example.postgesqlherokutest.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="cpf")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cpf;

    @Column(name="client_name")
    private String client_name;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

}
