package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public record AccountVO(@JsonIgnore Integer accountId,
                        @NotNull @Pattern(regexp = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}") String iban,
                        @NotEmpty List<CustomerVO> customers, @NotEmpty List<CardVO> debitCards,
                        List<CardVO> creditCards) {

    public AccountVO(Integer accountId, @JsonProperty(value = "iban", required = true) String iban,
                     @JsonProperty(value = "customers", required = true) List<CustomerVO> customers,
                     @JsonProperty(value = "debitCards", required = true) List<CardVO> debitCards,
                     @JsonProperty(value = "creditCards") List<CardVO> creditCards) {
        this.accountId = accountId;
        this.iban = iban;
        this.customers = customers;
        this.debitCards = debitCards;
        this.creditCards = creditCards;
    }
}
