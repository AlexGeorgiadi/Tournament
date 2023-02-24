package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
@Test
    public void player1ShouldWin() {
    Game game = new Game();
    Player player1 = new Player(1, "Player1", 30);
    Player player2 = new Player(2, "Player2", 20);

    game.register(player1);
    game.register(player2);
    int expected = 1;
    int actual = game.round("Player1", "Player2");

    Assertions.assertEquals(expected, actual);
}

    @Test
    public void player2ShouldWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 20);

        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 90);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldThrowExceptionPlayer2NotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 90);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                {
                    game.round("Player1", "Player2");
                });
    }
    @Test
    public void shouldThrowExceptionPlayer1NotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 90);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round("Player1", "Player2");
        });
    }
    @Test
    public void shouldThrowExceptionBothPlayersNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 90);
        Player player2 = new Player(2, "Player2", 90);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round("Player1", "Player2");
        });
    }
}
