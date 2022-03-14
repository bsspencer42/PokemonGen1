package DAO;

import Pokemon.Evolution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvolutionDAO {

    // Initialize pokedex
    public static HashMap<Integer, Evolution> evolutionInitialize(String fileName){
        List<List<String>> evolutionArray = new csvDAO(fileName).readFile();
        // Initialize HashMap/Dictionary
        HashMap<Integer, Evolution> evolutionHashMap = new HashMap<>();

        // Parse array into HashMap of PokemonObjects
        List<String> currentEvolutionString;
        Evolution currentEvolution;
        boolean isTrade;
        Map<String,Integer> stone;
        for (int i = 1; i < evolutionArray.size(); i++) {
            currentEvolutionString = evolutionArray.get(i);
            isTrade = false;
            stone = new HashMap<>();
            int currentPokemon = Integer.parseInt(currentEvolutionString.get(0));
            int currentEvoInt = Integer.parseInt(currentEvolutionString.get(1));
            int evoLevel;
            try{
                evoLevel =  Integer.parseInt(currentEvolutionString.get(2));
            }
            catch (NumberFormatException e){
                evoLevel = 0;
            }
            String currentStone = currentEvolutionString.get(3);

            // Check if pokemon already in map
            if (evolutionHashMap.containsKey(currentPokemon)){
                evolutionHashMap.get(currentPokemon).getStone().put(currentStone,currentEvoInt);
                continue;
            }

            // Trade
            if (currentEvolutionString.get(4) == "yes"){
                isTrade = true;
            }
            // Stone
            if (currentEvolutionString.get(3) != ""){
                stone.put(currentStone,currentEvoInt);
            }

            // Create pokemon object
            currentEvolution = new Evolution(
                    currentEvoInt,
                    evoLevel,
                    isTrade,
                    stone
            );

            // Add to dictionary
            evolutionHashMap.put(currentPokemon, currentEvolution);
        }
        return evolutionHashMap;
    }
}
