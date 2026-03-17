package com.projeto.blockchainapi.controller;

import com.projeto.blockchainapi.dto.ApiResponseDTO;
import com.projeto.blockchainapi.dto.TransactionRequestDTO;
import com.projeto.blockchainapi.model.Transaction;
import com.projeto.blockchainapi.service.BlockchainService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacoes")
public class TransactionController {

    private final BlockchainService blockchainService;

    public  TransactionController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }

    @Operation(summary = "Criar uma nova transação", description = "Adiciona uma nova transação à lista de transações pendentes. A transação será incluída no próximo bloco minerado.")
    @PostMapping
    public ResponseEntity<ApiResponseDTO> criarTransacao(@Valid @RequestBody TransactionRequestDTO transactionRequest) {
        Transaction transaction = new Transaction(
                transactionRequest.remetente(),
                transactionRequest.receptor(),
                transactionRequest.quantia()
        );

        blockchainService.adicionarTransacao(transaction);

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("Transação adicionada as Transações Pendentes"));
    }
}
