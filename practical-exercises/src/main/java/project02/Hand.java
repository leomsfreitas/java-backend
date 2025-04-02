package project02;

import project02.deck.Card;
import project02.deck.Deck;

public class Hand {
    private Player p1, p2;
    private Card vira;
    private Round[] rounds;
    private int currentRound;
    private Deck deck;

    public Hand(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.deck = new Deck();
        this.deck.shuffle();
        this.vira = deck.takeOne();
        this.p1.setCards(deck.take(3));
        this.p2.setCards(deck.take(3));
        this.rounds = new Round[3];
        this.currentRound = 0;
    }

    public void playRound() {
        if (currentRound < 3) {
            Round r = new Round(p1, p2, vira);
            rounds[currentRound++] = r;
            Player winner = r.getWinner();
            if (winner != null)
                System.out.println("Round won by: " + winner.getName());
            else
                System.out.println("Round tied.");
        }
    }

    public boolean isDone() {
        if (currentRound < 2) return false;
        int p1Wins = 0, p2Wins = 0;
        for (int i = 0; i < currentRound; i++) {
            Player winner = rounds[i].getWinner();
            if (winner == p1) p1Wins++;
            else if (winner == p2) p2Wins++;
        }
        return p1Wins == 2 || p2Wins == 2 || currentRound == 3;
    }

    public String getWinner() {
        if (!isDone()) return null;
        int[] wins = new int[2];
        for (int i = 0; i < currentRound; i++) {
            Player winner = rounds[i].getWinner();
            if (winner == p1) wins[0]++;
            else if (winner == p2) wins[1]++;
        }
        if (wins[0] == 2) return p1.getName();
        if (wins[1] == 2) return p2.getName();
        if (rounds[0].getWinner() == null) {
            if (rounds[1].getWinner() != null) return rounds[1].getWinner().getName();
            if (rounds[2].getWinner() != null) return rounds[2].getWinner().getName();
            return null;
        } else {
            if (rounds[1].getWinner() == null) return rounds[0].getWinner().getName();
            if (rounds[2].getWinner() == null) return rounds[0].getWinner().getName();
        }
        return null;
    }
}