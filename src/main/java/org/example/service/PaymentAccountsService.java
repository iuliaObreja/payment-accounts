package org.example.service;

import org.example.common.CardType;
import org.example.model.entity.Customer;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;

import java.util.List;

public interface PaymentAccountsService {

    void createAccount(AccountVO account);

    List<AccountVO> getAllAccounts();

    void addCardToAccount(Integer accountId, CardVO cardVO);

    void removeCardFromAccount(Integer accountId, Integer cardId);

    List<CardVO> getAllCards(String accountId, CardType cardType);
}
