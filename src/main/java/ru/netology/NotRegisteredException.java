package ru.netology;

// Пользовательское исключение,
// которое выбрасывается если игрок не зарегистрирован
public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String message) {
        super(message);
    }
}