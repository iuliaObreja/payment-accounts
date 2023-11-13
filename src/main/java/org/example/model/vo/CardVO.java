package org.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.common.CardType;

@AllArgsConstructor
@Getter
@Builder
public final class CardVO {
    private final CardType type;
    private final String number;
}
