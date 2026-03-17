package com.projeto.blockchainapi.controller;

import com.projeto.blockchainapi.dto.BlockResponseDTO;
import com.projeto.blockchainapi.mapper.BlockMapper;
import com.projeto.blockchainapi.model.Block;
import com.projeto.blockchainapi.service.BlockchainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mineracao")
public class MiningController {

    private final BlockchainService blockchainService;

    public MiningController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }

    @PostMapping
    public ResponseEntity<BlockResponseDTO> minerarBloco() {

        Block bloco = blockchainService.minerarBloco();

        return ResponseEntity.ok(BlockMapper.toDTO(bloco));
    }
}
