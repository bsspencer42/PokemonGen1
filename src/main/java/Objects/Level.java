package Objects;

public class Level {
    private int[][] base;
    private int[][] base2;

    public Level(int[][] base, int[][] base2) {
        this.base = base;
        this.base2 = base2;
    }

    public int[][] getBase() {
        return base;
    }

    public int[][] getBase2() {
        return base2;
    }
}
