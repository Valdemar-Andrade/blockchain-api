package com.projeto.blockchainapi.model;

import com.projeto.blockchainapi.util.HashUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    private int index;
    private long timestamp;
    private List<Transaction> transactions;
    private String previousHash;
    private int nonce;
    private String hash;

    public Block(int index,
                 long timestamp,
                 List<Transaction> transactions,
                 String previousHash) {

        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.hash = calcularHash();
    }

    public String calcularHash() {
        String dadosParaHash = index + Long.toString(timestamp) + transactions.toString() + previousHash + nonce;
        return HashUtil.aplicarSha256(dadosParaHash);
    }

    public void minerarBloco(int dificuldade) {

        String alvo = new String(new char[dificuldade]).replace('\0', '0');

        while (!hash.substring(0, dificuldade).equals(alvo)) {
            nonce++;
            hash = calcularHash();
        }
    }
}
