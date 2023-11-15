package org.example.service;

import org.example.common.CardType;
import org.example.model.entity.Account;
import org.example.model.entity.Card;
import org.example.model.mapper.AccountMapper;
import org.example.model.mapper.CardMapper;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.example.repository.AccountRepository;
import org.example.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.example.common.CardType.CREDIT;

@Service
public class PaymentAccountsServiceImpl implements PaymentAccountsService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public void createAccount(AccountVO account) {
        Account accountEntity = accountMapper.fromVoToEntity(account);
        accountRepository.save(accountEntity);
    }

    public List<AccountVO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::fromEntityToVo).toList();
    }

    @Transactional
    public void addCardToAccount(Integer accountId, CardVO cardVO) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        optionalAccount.ifPresent(account -> {
            Card cardToAttach = cardMapper.fromCardVoToEntity(cardVO);
            if (CREDIT.equals(cardVO.type())) {
                account.getCreditCards().add(cardToAttach);
            } else {
                account.getDebitCards().add(cardToAttach);
            }
        });
    }

    @Transactional
    public void removeCardFromAccount(Integer accountId, Integer cardId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        Optional<Card> optionalCard = cardRepository.findById(cardId);

        optionalAccount.ifPresent(account -> {
            optionalCard.ifPresent(card -> {
                if (CREDIT.equals(card.getType())) {
                    account.getCreditCards().remove(card);
                } else {
                    account.getDebitCards().remove(card);
                }
            });
        });
    }

    @Transactional(readOnly = true)
    public List<CardVO> getAllCards(Integer accountId, CardType cardType) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.isPresent() ? getCardVOsByType(optionalAccount.get(), cardType) : emptyList();
    }

    private List<CardVO> getCardVOsByType(Account account, CardType type) {
        return CREDIT.equals(type) ? account.getCreditCards().stream().map(cardMapper::fromCardEntityToVo).toList() :
                account.getDebitCards().stream().map(cardMapper::fromCardEntityToVo).toList();
    }
}
