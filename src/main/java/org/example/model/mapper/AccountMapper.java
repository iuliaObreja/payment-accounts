package org.example.model.mapper;

import org.example.model.entity.Account;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Component
public class AccountMapper {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public Account fromVoToEntity(AccountVO accountVO) {
        List<CardVO> creditCards = Optional.ofNullable(accountVO.creditCards()).orElse(emptyList());
        return Account.builder()
                .iban(accountVO.iban())
                .customers(accountVO.customers()
                        .stream()
                        .map(customerMapper::fromCustomerVoToEntity)
                        .toList())
                .creditCards(creditCards.stream()
                        .map(cardMapper::fromCardVoToEntity)
                        .toList()
                )
                .debitCards(accountVO.debitCards()
                        .stream()
                        .map(cardMapper::fromCardVoToEntity)
                        .toList()
                )
                .build();
    }

    public AccountVO fromEntityToVo(Account account) {
        return AccountVO.builder()
                .accountId(account.getAccountId())
                .iban(account.getIban())
                .customers(account.getCustomers()
                        .stream()
                        .map(customerMapper::fromCustomerEntityToVo)
                        .toList())
                .creditCards(account.getCreditCards()
                        .stream()
                        .map(cardMapper::fromCardEntityToVo)
                        .toList())
                .debitCards(account.getDebitCards()
                        .stream()
                        .map(cardMapper::fromCardEntityToVo)
                        .toList())
                .build();
    }
}
