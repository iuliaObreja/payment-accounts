package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Builder
@Getter
public class Account {
    @Id
    @GeneratedValue
    private final Integer id;

    @Column(name = "iban")
    private final String iban;

    // add relationship
    private final List<Customer> customers;
    // add relationship
    private final List<Card> creditCards;
    // add relationship
    private final List<Card> debitCards;
}
