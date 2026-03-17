package com.projeto.blockchainapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TransactionRequestDTO(
        @NotBlank
        String remetente,

        @NotBlank
        String receptor,

        @Positive
        double quantia
) { }
