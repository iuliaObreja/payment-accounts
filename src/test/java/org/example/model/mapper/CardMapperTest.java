package org.example.model.mapper;

import org.example.model.entity.Card;
import org.example.model.vo.CardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.common.CardType.CREDIT;
import static org.example.common.CardType.DEBIT;

@RunWith(MockitoJUnitRunner.class)
public class CardMapperTest {
    private final CardMapper cardMapper = new CardMapper();

    @Test
    public void shouldTransformFromVoToEntity() {
        CardVO cardVO = CardVO.builder().type(CREDIT).number("222999444777111").build();
        Card card = Card.builder().type(cardVO.type()).number(cardVO.number()).build();

        assertThat(cardMapper.fromCardVoToEntity(cardVO)).isEqualTo(card);
    }

    @Test
    public void shouldTransformFromEntityToVO() {
        Card card = Card.builder().cardId(1).type(DEBIT).number("22299993433455000").build();
        CardVO cardVO = CardVO.builder().id(card.getCardId()).type(card.getType()).number(card.getNumber()).build();

        assertThat(cardMapper.fromCardEntityToVo(card)).isEqualTo(cardVO);
    }
}
