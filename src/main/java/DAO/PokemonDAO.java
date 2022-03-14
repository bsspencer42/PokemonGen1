package DAO;
import Pokemon.PokemonBase;

import java.util.HashMap;
import java.util.List;

public class PokemonDAO {

    // Initialize pokedex
    public static HashMap<String, PokemonBase> pokedexInitialize(String fileName){
        List<List<String>> pokedexArray = new csvDAO(fileName).readFile();
        // Initialize HashMap/Dictionary
        HashMap<String, PokemonBase> pokedex = new HashMap<>();

        // Parse array into HashMap of PokemonObjects
        List<String> currentPokemon;
        PokemonBase currentPokemonObjBase;
        for (int i = 3; i < pokedexArray.size(); i++) {
            currentPokemon = pokedexArray.get(i);
            // Create pokemon object
            currentPokemonObjBase = new PokemonBase(
                    currentPokemon.get(0).split(";"),
                    Double.parseDouble(currentPokemon.get(1)),
                    Double.parseDouble(currentPokemon.get(2)),
                    Double.parseDouble(currentPokemon.get(3)),
                    Double.parseDouble(currentPokemon.get(4)),
                    Double.parseDouble(currentPokemon.get(5)),
                    Double.parseDouble(currentPokemon.get(6)),
                    Double.parseDouble(currentPokemon.get(7)),
                    Double.parseDouble(currentPokemon.get(8)),
                    Double.parseDouble(currentPokemon.get(9)),
                    Double.parseDouble(currentPokemon.get(10)),
                    Double.parseDouble(currentPokemon.get(11)),
                    Double.parseDouble(currentPokemon.get(12)),
                    Double.parseDouble(currentPokemon.get(13)),
                    Double.parseDouble(currentPokemon.get(14)),
                    Double.parseDouble(currentPokemon.get(15)),
                    Double.parseDouble(currentPokemon.get(16)),
                    Double.parseDouble(currentPokemon.get(17)),
                    Double.parseDouble(currentPokemon.get(18)),
                    Integer.parseInt(currentPokemon.get(19)),
                    Integer.parseInt(currentPokemon.get(20)),
                    Integer.parseInt(currentPokemon.get(21)),
                    Integer.parseInt(currentPokemon.get(22)),
                    Integer.parseInt(currentPokemon.get(23)),
                    currentPokemon.get(24),
                    Integer.parseInt(currentPokemon.get(25)),
                    Long.parseLong(currentPokemon.get(26)),
                    Double.parseDouble(currentPokemon.get(27)),
                    Integer.parseInt(currentPokemon.get(28)),
                    currentPokemon.get(30),
                    Double.parseDouble(currentPokemon.get(31)),
                    Integer.parseInt(currentPokemon.get(32)),
                    Integer.parseInt(currentPokemon.get(33)),
                    Integer.parseInt(currentPokemon.get(34)),
                    Integer.parseInt(currentPokemon.get(35)),
                    currentPokemon.get(36),
                    currentPokemon.get(37),
                    Double.parseDouble(currentPokemon.get(38)),
                    Integer.parseInt(currentPokemon.get(39)),
                    Boolean.parseBoolean(currentPokemon.get(40))
            );

            // Add to dictionary
            pokedex.put(currentPokemon.get(30), currentPokemonObjBase);
        }
        return pokedex;
    }

    public static HashMap<Integer, PokemonBase> pokedexByNumber(HashMap<String, PokemonBase> pokedex){
        HashMap<Integer, PokemonBase> pokedexByNumber = new HashMap<>();
        for (PokemonBase pokemon : pokedex.values()) {
            pokedexByNumber.put(pokemon.getPokedexNumber(), pokemon);
        }
        return pokedexByNumber;
    }

}
