package project02;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("João");
        Player p2 = new Player("Maria");
        Game game = new Game(p1, p2);

        while (game.isDone()) {
            game.play();
        }

        System.out.println("O vencedor do jogo foi: " + game.getWinner().getName());
    }
}
