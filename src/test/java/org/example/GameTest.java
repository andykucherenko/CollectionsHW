package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameTest {

    static Game game = new Game();

    @BeforeAll
    static void setGame() {
        Player player1 = new Player(1, "Петя", 100);
        Player player2 = new Player(2, "Аня", 400);
        Player player3 = new Player(2, "Федя", 400);

        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        int expected = 1;
        int actual = game.round("Аня", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        int expected = 1;
        int actual = game.round("Аня", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDrawGame() {
        int expected = 1;
        int actual = game.round("Аня", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Катала", "Аня");
        });
    }

    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Аня", "Катала");
        });
    }

    @Test
    public void testWhenTwoPlayersNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Катала", "Огрызок");
        });
    }
}
