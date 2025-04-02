package project02;

public class Game {
    private Player player1, player2;
    private Hand currentHand;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentHand = new Hand(player1, player2);
    }

    public void play() {
        if (currentHand.isDone()) {
            String winner = currentHand.getWinner();
            if (winner != null) {
                if (winner.equals(player1.getName())) player1.incrementScore();
            }
        }
    }

    public boolean isDone() {
        return player1.getScore() < 12 && player2.getScore() < 12;
    }

    public Player getWinner() {
        if (!isDone()) return null;
        return p1.getPoints() >= 12 ? player1 : player2;
    }
}
