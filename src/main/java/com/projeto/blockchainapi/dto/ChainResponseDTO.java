package com.projeto.blockchainapi.dto;

import com.projeto.blockchainapi.model.Block;

import java.util.List;

public record ChainResponseDTO(
        int length,
        List<Block> chain
) {
}
