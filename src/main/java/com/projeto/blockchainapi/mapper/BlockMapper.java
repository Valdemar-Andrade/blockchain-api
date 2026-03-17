package com.projeto.blockchainapi.mapper;

import com.projeto.blockchainapi.dto.BlockResponseDTO;
import com.projeto.blockchainapi.model.Block;

public class BlockMapper {

    public static BlockResponseDTO toDTO(Block block) {

        return new BlockResponseDTO(
                block.getIndex(),
                block.getHash(),
                block.getPreviousHash(),
                block.getTransactions()
        );
    }
}
