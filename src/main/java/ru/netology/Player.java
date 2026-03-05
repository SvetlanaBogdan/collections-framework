package ru.netology;

// Класс Player — дата-класс, описывающий игрока турнира
public class Player {

    // Уникальный идентификатор игрока
    private int id;

    // Имя игрока
    private String name;

    // Сила игрока (используется для определения победителя)
    private int strength;

    // Конструктор — создаёт нового игрока
    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    // Геттер для id
    public int getId() {
        return id;
    }

    // Геттер для имени игрока
    public String getName() {
        return name;
    }

    // Геттер для силы игрока
    public int getStrength() {
        return strength;
    }
}