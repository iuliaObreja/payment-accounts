package org.example.service;

import org.example.common.CardType;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentAccountsService {

    void createAccount(AccountVO account);

    void addCardToAccount(String accountId, CardVO cardVO);

    void removeCardFromAccount(Integer accountId, Integer cardId);
    List<CardVO> getAllCards(String accountId, CardType cardType);
}
