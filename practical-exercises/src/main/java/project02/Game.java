package project02;

public class Game {
    private Player p1, p2;
    private Hand currentHand;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.currentHand = new Hand(p1, p2);
    }

    public void play() {
        if (currentHand.isDone()) {
            String winner = currentHand.getWinner();
            if (winner != null) {
                if (winner.equals(p1.getName())) p1.addPoint();
                else p2.addPoint();
                System.out.println("Hand won by: " + winner);
            } else {
                System.out.println("Hand tied!");
            }
            currentHand = new Hand(p1, p2);
        }
        currentHand.playRound();
    }

    public boolean isDone() {
        return p1.getPoints() >= 12 || p2.getPoints() >= 12;
    }

    public Player getWinner() {
        if (!isDone()) return null;
        return p1.getPoints() >= 12 ? p1 : p2;
    }
}