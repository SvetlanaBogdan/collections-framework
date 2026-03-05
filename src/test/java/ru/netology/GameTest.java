package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    // Победа первого игрока
    // Сила первого игрока больше силы второго
    @Test
    public void shouldWinFirstPlayer() {

        Game game = new Game();

        // Создаем игроков
        Player player1 = new Player(1, "Joel", 10);
        Player player2 = new Player(1, "Ellie", 5);

        //Регистрируем игроков в турнире
        game.register(player1);
        game.register(player2);

        // Ожидаем победу первого игрока
        int expected = 1;

        // Фактический результат метода round
        int actual = game.round("Joel", "Ellie");

        // Проверяем совпадает ли результат
        assertEquals(expected, actual);
    }

    // Победа второго игрока
    // Сила второго игрока больше
    @Test
    public void shouldWinSecondPlayer() {

        Game game = new Game();

        // Создаём игроков
        Player player1 = new Player(1, "Joel", 5);
        Player player2 = new Player(2, "Ellie", 10);

        // Регистрируем игроков
        game.register(player1);
        game.register(player2);

        // Ожидаем победу второго игрока
        int expected = 2;

        int actual = game.round("Joel", "Ellie");

        assertEquals(expected, actual);
    }

    // Ничья
    // Сила игроков одинаковая
    @Test
    public void shouldDraw() {

        Game game = new Game();

        Player player1 = new Player(1, "Joel", 10);
        Player player2 = new Player(2, "Ellie", 10);

        game.register(player1);
        game.register(player2);

        // Ожидаем ничью
        int expected = 0;

        int actual = game.round("Joel", "Ellie");

        assertEquals(expected, actual);
    }

    // Если один из игроков не зарегистрирован
    // Должно выброситься исключение NotRegisteredException
    @Test
    public void shouldThrowExceptionIfPlayerNotRegistered() {

        Game game = new Game();

        // Регистрируем только одного игрока
        Player player1 = new Player(1, "Joel", 10);
        game.register(player1);

        // проверяем что выбрасывается исключение
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Joel", "Ellie");
        });
    }
}
