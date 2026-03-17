package com.projeto.blockchainapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Blockchain {

    private List<Block> chain = new ArrayList<>();
    private List<Transaction> transacoesPendentes = new ArrayList<>();
    private int dificuldade = 3;

    public Blockchain() {
        chain.add(criarBlocoGenesis());
    }

    private Block criarBlocoGenesis() {
        return new Block(0, System.currentTimeMillis(), new ArrayList<>(), "0", 0, "0");
    }

    public Block getUltimoBloco() {
        return chain.get(chain.size() - 1);
    }

    public void adicionarBloco(Block bloco) {
        bloco.setPreviousHash(getUltimoBloco().getHash());
        chain.add(bloco);
    }

    public void adicionarTransacao(Transaction transacao) {
        transacoesPendentes.add(transacao);
    }

    public Block minerarTransacoesPendentes() {
        Block bloco = new Block(chain.size(), System.currentTimeMillis(), transacoesPendentes, getUltimoBloco().getHash(), 0, "0");

        bloco.minerarBloco(dificuldade);
        adicionarBloco(bloco);
        transacoesPendentes = new ArrayList<>();

        return bloco;
    }

    public boolean isChainValid() {

        for (int i = 1; i < chain.size(); i++) {

            Block blocoAtual = chain.get(i);
            Block blocoAnterior = chain.get(i - 1);

            if (!blocoAtual.getHash().equals(blocoAtual.calcularHash())) {
                return false;
            }

            if (!blocoAtual.getPreviousHash().equals(blocoAnterior.getHash())) {
                return false;
            }
        }

        return true;
    }
}
