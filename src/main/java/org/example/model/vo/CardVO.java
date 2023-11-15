package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.example.common.CardType;

@Builder
public record CardVO(Integer id, CardType type, String number) {
    public CardVO(
            @JsonProperty(value = "id") Integer id,
            @JsonProperty(value = "type", required = true) CardType type,
            @JsonProperty(value = "number", required = true) String number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }
}
