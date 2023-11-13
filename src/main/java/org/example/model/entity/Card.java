package org.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.example.common.CardType;

@Entity
@Getter
@Builder
public class Card {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "type")
    private CardType type;

    @Column(name = "number")
    private String number;
}
