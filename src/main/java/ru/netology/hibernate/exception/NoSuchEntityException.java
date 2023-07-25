package ru.netology.hibernate.exception;

public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException(String msg) {
        super(msg);
    }
}