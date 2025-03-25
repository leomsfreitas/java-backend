package exercise_0;

public class Player {
    private String name;
    private int number;
    private String position;
    private Boolean isFielded;

    public Player(String name, int number, String position, Boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public String getStateAsString() {
        return "Nome: " + name + " Número: " + number + " Posição: " + position + " Em campo: " + (isFielded ? "Sim" : "Não");
    }

    public void setName(String name) {this.name = name;}

    public String getName() { return name; }

    public void setNumber(int number) { this.number = number; }

    public int getNumber() { return number; }

    public void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }

    public void setFielded(Boolean isFielded) { this.isFielded = isFielded; }

    public Boolean isFielded() { return isFielded; }
}
