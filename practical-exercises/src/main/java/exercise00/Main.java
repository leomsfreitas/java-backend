package exercise00;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("São Paulo", "São Paulo", "Luis Zubeldía");

        for (int i = 0; i < 18; i++) {
            Player player = new Player("Jogador " + i, i, "Posição " + i, i < 11);
            team.addPlayer(player);
        }

        team.setCaptain(team.getPlayers()[0]);

        System.out.println("\nNome do Time:");
        System.out.println(team.getName());

        System.out.println("\nLocalização do Time:");
        System.out.println(team.getBaseLocation());

        System.out.println("\nNome do Treinador:");
        System.out.println(team.getCoachName());

        System.out.println("\nCapitão:");
        System.out.println(team.getCaptain().getName());

        System.out.println("\nJogadores em Campo:");
        for (Player player : team.getFieldedPlayers()) {
            System.out.println(player.getStateAsString());
        }

        System.out.println("\nJogadores no Banco:");
        for (Player player : team.getOutfieldedPlayers()) {
            System.out.println(player.getStateAsString());
        }

        System.out.println("\nSubstituindo " + team.getPlayers()[0].getName() + " por " + team.getPlayers()[11].getName() + "...");
        team.substitute(team.getPlayers()[0], team.getPlayers()[11]);

        System.out.println("\nJogadores em Campo após substituição:");
        for (Player player : team.getFieldedPlayers()) {
            System.out.println(player.getStateAsString());
        }

        System.out.println("\nJogadores no Banco após substituição:");
        for (Player player : team.getOutfieldedPlayers()) {
            System.out.println(player.getStateAsString());
        }
    }
}
