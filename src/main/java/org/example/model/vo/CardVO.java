package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.common.CardType;

@Builder
public record CardVO (CardType type, String number) {
    public CardVO(
            @JsonProperty(value = "type", required = true) CardType type,
            @JsonProperty(value = "number", required = true) String number) {
        this.type = type;
        this.number = number;
    }
}
