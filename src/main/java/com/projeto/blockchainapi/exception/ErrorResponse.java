package com.projeto.blockchainapi.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
    String mensagem,
    String erro,
    int status,
    LocalDateTime timestamp
) { }
