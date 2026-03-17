package com.projeto.blockchainapi.dto;

import com.projeto.blockchainapi.model.Transaction;

import java.util.List;

public record BlockResponseDTO(
        int index,
        String hash,
        String previousHash,
        List<Transaction> transactions
) { }
