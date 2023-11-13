package org.example.service;

import org.example.common.CardType;
import org.example.model.entity.Account;
import org.example.model.mapper.AccountMapper;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Collections.emptyList;

public class PaymentAccountsServiceImpl implements PaymentAccountsService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void createAccount(AccountVO account) {
        Account accountEntity = accountMapper.fromVoToEntity(account);
        accountRepository.save(accountEntity);
    }

    @Transactional
    public void addCardToAccount(String accountId, CardVO cardVO) {

    }

    @Transactional
    public void removeCardFromAccount(Integer accountId, Integer cardId) {

    }

    @Transactional(readOnly = true)
    public List<CardVO> getAllCards(String accountId, CardType cardType) {
        return emptyList();
    }
}
