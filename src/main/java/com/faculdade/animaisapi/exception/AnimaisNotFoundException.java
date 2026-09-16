package com.faculdade.animaisapi.exception;

public class AnimaisNotFoundException extends RuntimeException {

    public AnimaisNotFoundException() {
        super("Animal não encontrado");
    }
}