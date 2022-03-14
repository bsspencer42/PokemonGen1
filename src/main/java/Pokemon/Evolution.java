package Pokemon;

import java.util.Map;

public class Evolution {
    // Instance Variables
    private int evolution;
    private int level;
    private boolean trade;
    private Map<String, Integer> stone;

    // Constructor
    public Evolution(int evolution, int level, boolean trade, Map<String,Integer> stone){
        this.evolution = evolution;
        this.level = level;
        this.trade = trade;
        this.stone = stone;
    }

    // Getters and Setters


    public int getEvolution() {
        return evolution;
    }

    public int getLevel() {
        return level;
    }

    public boolean isTrade() {
        return trade;
    }

    public Map<String, Integer> getStone() {
        return stone;
    }

    @Override
    public String toString() {
        return "Evolution{" +
                "evolution=" + evolution +
                ", level=" + level +
                ", trade=" + trade +
                ", stone=" + stone +
                '}';
    }
}
