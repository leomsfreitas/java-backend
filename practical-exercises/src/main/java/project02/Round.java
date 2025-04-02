package project02;

import project02.deck.Card;

public class Round {
    private Card card1;
    private Card card2;
    private Player winner;

    public Round(Player p1, Player p2, Card vira) {
        this.card1 = p1.chooseCard();
        this.card2 = p2.chooseCard();
        int result = card1.compareValueTo(card2, vira);
        if (result > 0) winner = p1;
        else if (result < 0) winner = p2;
        else winner = null;
    }

    public Player getWinner() {
        return winner;
    }
}
