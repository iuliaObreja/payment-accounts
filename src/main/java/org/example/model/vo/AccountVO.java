package org.example.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountVO {
    @NotNull
    @Pattern(regexp = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}")
    private final String iban;
    @NotEmpty
    private final List<CustomerVO> customers;
    @NotEmpty
    private final List<CardVO> debitCards;
    private final List<CardVO> creditCards;

    public AccountVO(@JsonProperty(value = "iban", required = true) String iban,
                     @JsonProperty(value = "customers", required = true) List<CustomerVO> customers,
                     @JsonProperty(value = "debitCards", required = true) List<CardVO> debitCards,
                     @JsonProperty(value = "creditCards") List<CardVO> creditCards) {
        this.iban = iban;
        this.customers = customers;
        this.debitCards = debitCards;
        this.creditCards = creditCards;
    }

}
