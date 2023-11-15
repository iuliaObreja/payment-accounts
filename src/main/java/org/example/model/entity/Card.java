package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.example.common.CardType;

@Entity
@Data
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    @Column(name = "type")
    private CardType type;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
