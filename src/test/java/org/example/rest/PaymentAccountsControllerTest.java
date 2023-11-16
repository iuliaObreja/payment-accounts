package org.example.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.App;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.example.model.vo.CustomerVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.example.common.CardType.DEBIT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = App.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PaymentAccountsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAllAccounts() throws Exception {
        mockMvc.perform(get("/payment/accounts")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void shouldCreateAccount() throws Exception {
        CardVO cardVO = CardVO.builder().id(1).type(DEBIT).number("2222666688889990").build();
        AccountVO accountVO = AccountVO.builder()
                .accountId(1)
                .iban("DE89370400440532013000")
                .customers(singletonList(CustomerVO.builder().name("Ana").build()))
                .debitCards(singletonList(cardVO))
                .build();

        AccountVO expectedAccountVO = AccountVO.builder()
                .accountId(1)
                .iban(accountVO.iban())
                .customers(accountVO.customers())
                .debitCards(singletonList(CardVO.builder().id(1).type(cardVO.type()).number(cardVO.number()).build()))
                .creditCards(emptyList())
                .build();

        mockMvc.perform(post("/payment/accounts").contentType(APPLICATION_JSON).content(asJsonString(accountVO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(asJsonString(expectedAccountVO)));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
