package com.projeto.blockchainapi.service;

import com.projeto.blockchainapi.exception.BlockchainException;
import com.projeto.blockchainapi.model.Block;
import com.projeto.blockchainapi.model.Blockchain;
import com.projeto.blockchainapi.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockchainService {

    private static final Logger log = LoggerFactory.getLogger(BlockchainService.class);
    private final Blockchain blockchain =  new Blockchain();

    public void adicionarTransacao(Transaction transaction) {
        log.info("Adicionando Transação: {} -> {} ({})",
                transaction.getRemetente(),
                transaction.getReceptor(),
                transaction.getQuantia());

        if(transaction.getQuantia() <= 0){
            log.warn("Transação inválida: quantia deve ser maior que zero. Transação: {} -> {} ({})",
                    transaction.getRemetente(),
                    transaction.getReceptor(),
                    transaction.getQuantia());

            throw new BlockchainException("A quantia da transação deve ser maior que zero.");
        }
        blockchain.adicionarTransacao(transaction);
    }

    public Block minerarBloco() {
        log.info("Iniciando processo de mineração de bloco...");

        Block bloco = blockchain.minerarTransacoesPendentes();

        log.info("Bloco minerado com sucesso!: index={}, hash={}", bloco.getIndex(), bloco.getHash());

        return bloco;
    }

    public List<Block> getChain() {
        return blockchain.getChain();
    }

    public boolean isChainValid() {
        log.debug("Validando integridade da blockchain...");

        boolean valido = blockchain.isChainValid();

        if (valido) {
            log.info("Blockchain validado com sucesso!");
        }else {
            log.warn("Validação da blockchain falhou!");
        }

        return valido;
    }
}
