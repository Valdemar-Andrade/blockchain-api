package com.projeto.blockchainapi.controller;

import com.projeto.blockchainapi.dto.BlockResponseDTO;
import com.projeto.blockchainapi.service.BlockchainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blockchain")
public class BlockchainController {

    private final BlockchainService blockchainService;

    public BlockchainController(BlockchainService blockchainService) {
        this.blockchainService = blockchainService;
    }

    @GetMapping
    public List<BlockResponseDTO> getChain() {
        return blockchainService.getChain().stream()
                .map(block -> new BlockResponseDTO(
                        block.getIndex(),
                        block.getHash(),
                        block.getPreviousHash(),
                        block.getTransactions()
                ))
                .toList();
    }

    @GetMapping("/validate")
    public boolean validateChain() {
        return blockchainService.isChainValid();
    }
}
