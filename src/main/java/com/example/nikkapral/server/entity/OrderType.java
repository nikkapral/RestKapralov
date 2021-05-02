package com.example.nikkapral.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orderTypes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Integer price;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderType")
    private List<Order> orderList;
}