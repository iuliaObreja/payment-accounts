package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String name;
    private Date birthday;

    public Customer(){}

    public Customer(Integer customerId, String name, Date birthday) {
        this.customerId = customerId;
        this.name = name;
        this.birthday = birthday;
    }
}
