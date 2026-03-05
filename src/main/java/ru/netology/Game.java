package ru.netology;

import java.util.ArrayList;
import java.util.List;

// Класс Game — управляет турниром игроков
public class Game {

    // Список зарегистрированных игроков
    private List<Player> players = new ArrayList<>();

    // Метод регистрации игрока в турнире
    public void register(Player player) {
        players.add(player);
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
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
}