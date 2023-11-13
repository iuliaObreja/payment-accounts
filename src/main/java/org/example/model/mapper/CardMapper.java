package org.example.model.mapper;

import org.example.model.entity.Card;
import org.example.model.vo.CardVO;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
    public Card fromCardVoToEntity(CardVO cardVO) {
        return Card.builder()
                .type(cardVO.getType())
                .number(cardVO.getNumber())
                .build();
    }

    public CardVO fromCardEntityToVo(Card card) {
        return CardVO.builder()
                .type(card.getType())
                .number(card.getNumber())
                .build();
    }
}
