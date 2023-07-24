package ru.netology.hibernate.exception;

public class NoSuchCityException extends RuntimeException {
    public NoSuchCityException(String msg) {
        super(msg);
    }
}