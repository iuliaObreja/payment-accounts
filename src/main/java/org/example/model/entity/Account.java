package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "iban")
    private String iban;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> creditCards;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> debitCards;

    public Account(Integer accountId, String iban, List<Customer> customers, List<Card> creditCards, List<Card> debitCards) {
        this.accountId = accountId;
        this.iban = iban;
        this.customers = customers;
        this.creditCards = creditCards;
        this.debitCards = debitCards;
    }

    public Account() {
    }
}
