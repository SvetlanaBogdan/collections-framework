package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс Game — управляет турниром игроков
public class Game {

    // Храним игроков в HashMap для быстрого поиска по имени
    private Map<String, Player> players = new HashMap<>();

    // Регистрируем игрока по его имени
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    // Метод проведения раунда между двумя игроками
    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        // Если хотя бы один игрок не найден — выбрасываем исключение
        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }

        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        // Сравниваем силу игроков
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }

        // Если силы равны — ничья
        return 0;
    }

    // Метод поиска игрока по имени среди зарегистрированных
    public Player findByName(String name) {

        // Получаем игрока по имени из HashMap
        Player player = players.get(name);

        // Возвращаем найденного игрока (или null если нет)
        return player;
    }
    }