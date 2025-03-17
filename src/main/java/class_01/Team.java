package class_01;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private final int MAX_PLAYERS = 18;
    private Player[] players = new Player[MAX_PLAYERS];
    private int playerCount = 0;
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public String getName() { return name; }

    public String getBaseLocation() { return baseLocation; }

    public String getCoachName() { return coachName; }

    public void addPlayer(Player player) {
        if (playerCount < MAX_PLAYERS) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Número máximo de jogadores atingido.");
        }
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < playerCount; i++) {
            if (players[i] == player) {
                for (int j = i; j < playerCount - 1; j++) {
                    players[j] = players[j + 1];
                }
                players[playerCount - 1] = null;
                playerCount--;
                System.out.println(player.getName() + " removido com sucesso.");
                return;
            }
        }
    }

    public void substitute(Player substitute, Player starter) {
        if (!starter.isFielded()) {
            return;
        }
        if (substitute.isFielded()) {
            return;
        }

        starter.setFielded(false);
        substitute.setFielded(false);
        System.out.println(starter.getName() + " substituído com sucesso por " + substitute.getName());
    }

    public void setCaptain(Player captain) { this.captain = captain; }

    public Player getCaptain() { return this.captain; }

    public Player[] getFieldedPlayers() {
        int countFielded = 0;
        for (int i = 0; i < playerCount; i++) {
            if (players[i].isFielded()) {
                countFielded++;
            }
        }

        Player[] fieldedPlayers = new Player[countFielded];
        int idx = 0;
        for (int i = 0; i < playerCount; i++) {
            if (players[i].isFielded()) {
                fieldedPlayers[idx++] = players[i];
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        int countOutfielded = 0;
        for (int i = 0; i < playerCount; i++) {
            if (!players[i].isFielded()) {
                countOutfielded++;
            }
        }

        Player[] outfieldedPlayers = new Player[countOutfielded];
        int idx = 0;
        for (int i = 0; i < playerCount; i++) {
            if (!players[i].isFielded()) {
                outfieldedPlayers[idx++] = players[i];
            }
        }
        return outfieldedPlayers;
    }

    public Player[] getPlayers() { return players; }
}

