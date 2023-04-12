package org.example;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public Player getByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = getByName(playerName1);
        Player player2 = getByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован: " + playerName1);
        } else if (player2 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован: " + playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
