package ru.netology.jdbc.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Entity
@Table(name = "orders", schema = "netology")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private Date date;
    @ManyToOne(optional = false, targetEntity = ru.netology.jdbc.entity.Customer.class)
    @JoinColumn(name = "customer_id")
    private int customer_id;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false)
    private BigDecimal amount;
}