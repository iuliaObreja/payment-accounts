package org.example.model.mapper;

import org.example.model.entity.Account;
import org.example.model.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public Account fromVoToEntity(AccountVO accountVO) {
        return Account.builder()
                .iban(accountVO.getIban())
                .customers(accountVO.getCustomers()
                        .stream()
                        .map(customerMapper::fromCustomerVoToEntity)
                        .toList())
                .creditCards(accountVO.getCreditCards()
                        .stream()
                        .map(cardMapper::fromCardVoToEntity)
                        .toList())
                .debitCards(accountVO.getDebitCards()
                        .stream()
                        .map(cardMapper::fromCardVoToEntity)
                        .toList())
                .build();
    }

    public AccountVO fromEntityToVo(Account account) {
        return AccountVO.builder()
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
