package base.example.base2;

import java.util.Random;

public class Player {
    private VARIANTS choice;
    private String name;


    public Player() {
        this.choice = randomChoice();
        this.name = "Bot";
    }

    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    private VARIANTS randomChoice() {
        int pick = new Random().nextInt(VARIANTS.values().length);
        return VARIANTS.values()[pick];
    }

    public String whoWins(Player player1, Player player2) {
        if (player1.choice == player2.choice) {
            return "Ничья";
        }

        switch (player1.choice) {
            case ROCK:
                return (player2.choice == VARIANTS.SCISSORS) ? "Победил игрок с именем: "
                        + player1.name : "Победил игрок с именем: " + player2.name;
            case PAPER:
                return (player2.choice == VARIANTS.ROCK) ? "Победил игрок с именем: "
                        + player1.name : "Победил игрок с именем: " + player2.name;
            case SCISSORS:
                return (player2.choice == VARIANTS.PAPER) ? "Победил игрок с именем: "
                        + player1.name : "Победил игрок с именем: " + player2.name;
        }
        return "Ошибка";
    }
}

