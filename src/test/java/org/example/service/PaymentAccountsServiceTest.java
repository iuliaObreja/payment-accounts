package org.example.service;

import org.example.model.entity.Account;
import org.example.model.entity.Card;
import org.example.model.entity.Customer;
import org.example.model.mapper.AccountMapper;
import org.example.model.mapper.CardMapper;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.example.model.vo.CustomerVO;
import org.example.repository.AccountRepository;
import org.example.repository.CardRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.common.CardType.DEBIT;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PaymentAccountsServiceTest {

    @TestConfiguration
    static class PaymentAccountsServiceImplContextConfiguration {

        @Bean
        public PaymentAccountsService employeeService() {
            return new PaymentAccountsServiceImpl();
        }
    }

    private Account account;
    private AccountVO accountVO;

    @MockBean
    @Qualifier("accountMapper")
    private AccountMapper accountMapper;

    @MockBean
    private CardMapper cardMapper;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    PaymentAccountsService paymentAccountsService;

    @BeforeEach
    public void setupVariables() {
        account = Account.builder()
                .accountId(1)
                .iban("DE89370400440532013000")
                .customers(singletonList(Customer.builder().name("John").build()))
                .debitCards(singletonList(Card.builder().cardId(123).number("233456667432214421").type(DEBIT).build()))
                .build();

        Card card = account.getCreditCards().get(0);
        accountVO = AccountVO.builder()
                .accountId(account.getAccountId())
                .iban(account.getIban())
                .customers(singletonList(CustomerVO.builder().name(account.getCustomers().get(0).getName()).build()))
                .debitCards((singletonList(CardVO.builder().id(card.getCardId()).number(card.getNumber()).type(card.getType()).build())))
                .build();
    }

    @Test
    public void createAccount() {
        when(accountMapper.fromVoToEntity(accountVO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.fromEntityToVo(account)).thenReturn(accountVO);

        AccountVO createdAccount = paymentAccountsService.createAccount(accountVO);

        assertThat(createdAccount).isNotNull().isEqualTo(accountVO);
        verify(accountMapper, times(1)).fromVoToEntity(accountVO);
        verify(accountRepository, times(1)).save(account);
        verify(accountMapper, times(1)).fromEntityToVo(account);
    }
}
