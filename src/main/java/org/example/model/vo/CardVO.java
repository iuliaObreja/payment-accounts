package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.example.common.CardType;

@Data
@Builder
public class CardVO {

    private final CardType type;
    private final String number;

    public CardVO(
            @JsonProperty(value = "type", required = true) CardType cardType,
            @JsonProperty(value = "number", required = true) String number
    ) {
        this.type = cardType;
        this.number = number;
    }
}
