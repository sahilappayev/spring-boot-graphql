package com.example.graphql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Table(name = "user_")
@Entity
@Getter
@Setter
public class User extends BaseEntity {

    private String name;

    private String surname;

    private LocalDate birthdate;

    @OneToMany(mappedBy = "user")
    private List<Laptop> laptops;

}
