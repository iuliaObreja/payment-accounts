package org.example.model.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public final class AccountVO {
    @NotNull
    @Pattern(regexp = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}")
    private final String iban;
    @NotEmpty
    private final List<CustomerVO> customers;
    @NotEmpty
    private final List<CardVO> creditCards;
    @NotEmpty
    private final List<CardVO> debitCards;
}
