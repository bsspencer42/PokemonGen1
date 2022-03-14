package Pokemon;

import Services.MoveService;

import java.util.*;

public class PokemonMoveSet {

    private int pokedexNumber;
    private int versionGroupID;
    private HashMap<Integer, ArrayList<Integer>> moveMapping;
    private HashMap<Integer,PokemonBase> pokedexByNumber;
    private MoveService moveService;

    public PokemonMoveSet(int pokedexNumber, int versionGroupID, HashMap<Integer, ArrayList<Integer>> moveMapping,HashMap<Integer,PokemonBase> pokedexByNumber,MoveService moveService){
        this.pokedexNumber = pokedexNumber;
        this.versionGroupID = versionGroupID;
        this.moveMapping = new HashMap<>();
        this.pokedexByNumber = pokedexByNumber;
        this.moveService = moveService;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public int getVersionGroupID() {
        return versionGroupID;
    }

    public HashMap<Integer, ArrayList<Integer>> getMoveMapping() {
        return moveMapping;
    }

    @Override
    public String toString() {
        StringBuilder moveSet = new StringBuilder();
        // Get keys as sort list
        ArrayList<Integer> levels = new ArrayList<>(moveMapping.keySet());
        Collections.sort(levels);
        // Print pokemon info
        String pokemon = pokedexByNumber.get(pokedexNumber).getName();
        moveSet.append(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        moveSet.append(System.getProperty("line.separator"));
        //System.out.println(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        // Iterate through levels starting at earliest
        for (int i = 0; i < levels.size(); i++) {
            int level = levels.get(i);
            ArrayList<Integer> currentLevel = moveMapping.get(level);
            // Iterate through each Move at level
            for (int j = 0; j < currentLevel.size() ; j++) {
                // Current Move
                int currentMove = currentLevel.get(j);
                if (currentMove > 0){
                    Move move = moveService.getMove(currentMove);
                    moveSet.append(String.format("Level %d: %s", level, move.getName()));
                    moveSet.append(System.getProperty("line.separator"));
                    //System.out.println(String.format("Level %d: %s", level, move.getName()));
                }
            }
        }
        moveSet.append(System.getProperty("line.separator"));
        return moveSet.toString();
    }

    public String movesByLevelUp() {
        StringBuilder moveSet = new StringBuilder();
        // Get keys as sort list
        ArrayList<Integer> levels = new ArrayList<>(moveMapping.keySet());
        Collections.sort(levels);
        // Print pokemon info
        String pokemon = pokedexByNumber.get(pokedexNumber).getName();
        moveSet.append(String.format("Moves by Level Up"));
        moveSet.append(System.getProperty("line.separator"));
        moveSet.append(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        moveSet.append(System.getProperty("line.separator"));
        //System.out.println(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        // Iterate through levels starting at earliest
        for (int i = 0; i < levels.size(); i++) {
            int level = levels.get(i);
            if (level > 0) {
                ArrayList<Integer> currentLevel = moveMapping.get(level);
                // Iterate through each Move at level
                for (int j = 0; j < currentLevel.size(); j++) {
                    // Current Move
                    int currentMove = currentLevel.get(j);
                    if (currentMove > 0) {
                        Move move = moveService.getMove(currentMove);
                        moveSet.append(String.format("Level %d: %s", level, move.getName()));
                        moveSet.append(System.getProperty("line.separator"));
                        //System.out.println(String.format("Level %d: %s", level, move.getName()));
                    }
                }
            }
        }
        moveSet.append(System.getProperty("line.separator"));
        return moveSet.toString();
    }

    public String movesByTeach() {
        StringBuilder moveSet = new StringBuilder();
        // Print pokemon info
        String pokemon = pokedexByNumber.get(pokedexNumber).getName();
        moveSet.append(String.format("Moves by Teach"));
        moveSet.append(System.getProperty("line.separator"));
        moveSet.append(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        moveSet.append(System.getProperty("line.separator"));
        //System.out.println(String.format("Pokemon #%d : %s",pokedexNumber, pokemon));
        // Iterate through levels starting at earliest
            int level = 0;
            ArrayList<Integer> currentLevel = moveMapping.get(level);
            // Iterate through each Move at level
            for (int i = 0; i < currentLevel.size() ; i++) {
                // Current Move
                int currentMove = currentLevel.get(i);
                if (currentMove > 0) {
                    Move move = moveService.getMove(currentMove);
                    moveSet.append(String.format("Level %d: %s", level, move.getName()));
                    moveSet.append(System.getProperty("line.separator"));
                    //System.out.println(String.format("Level %d: %s", level, move.getName()));
                }
            }
        moveSet.append(System.getProperty("line.separator"));
        return moveSet.toString();
    }

}
