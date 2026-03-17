package com.projeto.blockchainapi.service;

import com.projeto.blockchainapi.dto.TransactionRequestDTO;
import com.projeto.blockchainapi.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transacoesPendentes = new ArrayList<>();

    public void addTransacao(TransactionRequestDTO transactionDto) {
        Transaction transaction = new Transaction(
                transactionDto.remetente(),
                transactionDto.receptor(),
                transactionDto.quantia()
        );
        transacoesPendentes.add(transaction);
    }

    public List<Transaction> getTransacoesPendentes() {
        return transacoesPendentes;
    }
}
