package project02;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("John");
        Player p2 = new Player("Mary");
        Game game = new Game(p1, p2);

        while (!game.isDone()) {
            game.play();
        }

        System.out.println("The winner of the game is: " + game.getWinner().getName());
    }
}