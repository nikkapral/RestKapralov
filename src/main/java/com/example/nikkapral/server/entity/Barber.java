package com.example.nikkapral.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "barbers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone_number;
    private String sex; // male/female
    private Integer age;
    private Date hire_date;
    private Integer salary;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "barber")
    private List<Order> orderList;
}