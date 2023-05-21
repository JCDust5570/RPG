

public class Monstro {
    public Status status;

    private Monstro(Status status) {
        this.status = status;
    }

    public static Monstro createSlime() {
        Status slimeStatus = Status.createStatus("Slime", 2, 0, 1, 5, 0, 0, 1, 1);
        Monstro slimeMonstro = new Monstro(slimeStatus);
        return slimeMonstro;
    }

}

