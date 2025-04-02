package project02;

import project02.deck.Card;
import project02.deck.Deck;

public class Hand {
    private Player player1, player2;
    private Card vira;
    private Round[] rounds;
    private int currentRound;
    private Deck deck;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Deck();
        this.deck.shuffle();
        this.vira = deck.takeOne();
        this.player1.setCards(deck.take(3));
        this.player2.setCards(deck.take(3));
        this.rounds = new Round[3];
        this.currentRound = 0;
    }

    public void playRound() {
        if (currentRound < 3) {
            Round r = new Round(player1, player2, vira);
            rounds[currentRound++] = r;
            Player winner = r.getWinner();
            if (winner != null)
                System.out.println("Rodada vencida por: " + winner.getName());
            else
                System.out.println("Rodada empatada.");
        }
    }

    public boolean isDone() {
        if (currentRound < 2) return false;
        int player1Wins = 0, player2Wins = 0;
        for (int i = 0; i < currentRound; i++) {
            Player winner = rounds[i].getWinner();
            if (winner == player1) player1Wins++;
            else if (winner == player2) player2Wins++;
        }
        return player1Wins == 2 || player2Wins == 2 || currentRound == 3;
    }

    public String getWinner() {
        if (!isDone()) return null;
        int[] wins = new int[2];
        for (int i = 0; i < currentRound; i++) {
            Player winner = rounds[i].getWinner();
            if (winner == player1) wins[0]++;
            else if (winner == player2) wins[1]++;
        }
        if (wins[0] == 2) return player1.getName();
        if (wins[1] == 2) return player2.getName();
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
