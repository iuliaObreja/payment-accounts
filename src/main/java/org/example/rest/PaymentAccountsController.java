package org.example.rest;

import jakarta.validation.Valid;
import org.example.common.CardType;
import org.example.model.vo.AccountVO;
import org.example.model.vo.CardVO;
import org.example.service.PaymentAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment/accounts")
public class PaymentAccountsController {

    @Autowired
    public PaymentAccountsService paymentAccountsService;

    @PostMapping
    public ResponseEntity<String> createAccount(@Valid @RequestBody AccountVO account) {
        paymentAccountsService.createAccount(account);
        return ResponseEntity.ok("Account created");
    }

    @GetMapping
    public ResponseEntity<List<AccountVO>> getAllAccounts() {
        return ResponseEntity.ok(paymentAccountsService.getAllAccounts());
    }

    @PutMapping("/{id}/add/card")
    public void addCard(@PathVariable Integer id, @Valid @RequestBody CardVO cardVO) {
        paymentAccountsService.addCardToAccount(id, cardVO);
    }

    @PutMapping("/{id}/delete/card")
    public void deleteCard(@PathVariable Integer id,
                           @RequestParam(value = "id") Integer cardId) {
        paymentAccountsService.removeCardFromAccount(id, cardId);
    }

    @GetMapping("/{id}/cards")
    public List<CardVO> getAllCards(@PathVariable String id, @RequestParam(value = "type") CardType type) {
        return paymentAccountsService.getAllCards(id, type);
    }
}
