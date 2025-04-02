package project02;

import project02.deck.Card;

public class Round {
    private Card card1, card2;
    private String winner;

    public Round(String player1, Card card1, String player2, Card card2, Card vira) {
        this.card1 = card1;
        this.card2 = card2;
        int result = card1.compareValueTo(card2, vira);
        if (result > 0) winner = player1;
        else if (result < 0) winner = player2;
        else winner = null;
    }

    public String getWinner() {
        return winner;
    }
}
