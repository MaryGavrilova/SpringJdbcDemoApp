package ru.netology.springjdbcdemo.exception;

public class EmptyResultDataException extends RuntimeException {
    public EmptyResultDataException(String msg) {
        super(msg);
    }
}