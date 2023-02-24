package ru.netology.tournament;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerNames = new ArrayList<>();

    public void register(Player player) {
        playerNames.add(player);
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : playerNames) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        for (Player player : playerNames) {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            }
        }
        return 0;
    }
}
