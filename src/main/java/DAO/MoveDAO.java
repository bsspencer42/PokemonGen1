package DAO;

import Pokemon.Move;
import Pokemon.PokemonBase;
import Pokemon.PokemonMoveSet;
import Services.MoveService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoveDAO {
    // Instance variables
    //private HashMap<String, Move> moveHashMap;

//    // Constructor
//    public MoveDAO(String fileName){
//        moveInitialize(new csvDAO(fileName).readPokedexFile());
//    }

    // Initialize pokedex
    public static HashMap<String, Move> moveInitialize(String fileName){
        List<List<String>> evolutionArray = new csvDAO(fileName).readFile();
        // Initialize HashMap/Dictionary
        HashMap<String, Move> moveHashMap = new HashMap<>();

        // Parse array into HashMap of PokemonObjects
        List<String> currentMoveString;
        Move currentMove;
        for (int i = 1; i < evolutionArray.size(); i++) {
            currentMoveString = evolutionArray.get(i);
            String name = currentMoveString.get(0);
            String type = currentMoveString.get(1);
            String category = currentMoveString.get(2);
            String effect = currentMoveString.get(3);
            // Power parse
            Integer power;
            if (currentMoveString.get(4).equals("-")) {
                power = null;
            }
            else {
                power = Integer.parseInt(currentMoveString.get(4));
            }
            // Parse accuracy
            Integer accuracy;
            if (currentMoveString.get(5).equals("inf")){
                accuracy = -1;
            }
            else if (currentMoveString.get(5).equals("-")){
                accuracy = null;
            }
            else {
                accuracy = Integer.parseInt(currentMoveString.get(5));
            }
            // Parse PP
            Integer PP;
            if (currentMoveString.get(6).equals("-")){
               PP = null;
            }
            else {
                PP = Integer.parseInt(currentMoveString.get(6));
            }
            // Parse TM
            String TM;
            if (currentMoveString.get(7).equals("")){
                TM = null;
            }
            else {
                TM = currentMoveString.get(7);
            }
            // Parse Probability
            Integer probability;
            // Z move (Gen 7)
            if (currentMoveString.get(8).equals("")){
                probability = null;
            }
            // Not a consideration for the move
            else if (currentMoveString.get(8).equals("-")){
                probability = -1;
            }
            // Regular move
            else {
                probability = Integer.parseInt(currentMoveString.get(8));
            }
            int gen = Integer.parseInt(currentMoveString.get(9));
            // New Properties
            Integer ID;
            if (currentMoveString.get(10).equals("-")) {
                ID = null;
            }
            else {
                ID = Integer.parseInt(currentMoveString.get(10));
            }
            Integer targetID;
            if (currentMoveString.get(11).equals("-")) {
                targetID = null;
            }
            else {
                targetID = Integer.parseInt(currentMoveString.get(11));
            }
            Integer damageClassID;
            if (currentMoveString.get(12).equals("-")) {
                damageClassID = null;
            }
            else {
                damageClassID = Integer.parseInt(currentMoveString.get(12));
            }
            Integer effectID;
            if (currentMoveString.get(13).equals("-")) {
                effectID = null;
            }
            else {
                effectID = Integer.parseInt(currentMoveString.get(13));
            }
            Integer effectProb;
            if (currentMoveString.get(14).equals("-")) {
                effectProb = null;
            }
            else {
                effectProb = Integer.parseInt(currentMoveString.get(14));
            }
            Integer contestTypeID;
            if (currentMoveString.get(15).equals("-")) {
                contestTypeID = null;
            }
            else {
                contestTypeID = Integer.parseInt(currentMoveString.get(15));
            }
            Integer contestEffectID;
            if (currentMoveString.get(16).equals("-")) {
                contestEffectID = null;
            }
            else {
                contestEffectID = Integer.parseInt(currentMoveString.get(16));
            }
            Integer superContestEffectID;
            if (currentMoveString.get(17).equals("-")) {
                superContestEffectID = null;
            }
            else {
                superContestEffectID = Integer.parseInt(currentMoveString.get(17));
            }
            // Create pokemon object
            currentMove = new Move(
                    name, type, category, power, accuracy, PP,
                    effect, probability, TM, gen, ID, targetID, damageClassID,
                    effectID, effectProb, contestTypeID, contestEffectID, superContestEffectID
            );
            // Add to dictionary
            moveHashMap.put(name, currentMove);
        }
        return moveHashMap;
    }

    public static HashMap<Integer, PokemonMoveSet> moveMapping(String fileName, HashMap<Integer, PokemonBase> pokedexByNumber, MoveService moveService) {
        List<List<String>> moveMappingStringArray = new csvDAO(fileName).readFile();
        //     PokeDex#            Level        Moveset
        HashMap<Integer, PokemonMoveSet> moveMapping = new HashMap<>();

        List<String> currentPokemonMoveData = null;
        ArrayList<Integer> moveList;
        for (int i = 1; i < moveMappingStringArray.size(); i++) {
            currentPokemonMoveData = moveMappingStringArray.get(i);
            int pokemonNumber = Integer.parseInt(currentPokemonMoveData.get(0));
            int versionGroupID = Integer.parseInt(currentPokemonMoveData.get(1));
            int moveID = Integer.parseInt(currentPokemonMoveData.get(2));
            int level = Integer.parseInt(currentPokemonMoveData.get(4));
            int order;
            if (currentPokemonMoveData.get(5).equals("-")){
                order = 1;
            }
            else {
                order = Integer.parseInt(currentPokemonMoveData.get(5));
            }
            // Check if pokemon is not in moveMapping
            if (moveMapping.get(pokemonNumber) == null) {
                // Create new moves arraylist
                ArrayList<Integer> moves = new ArrayList<>();
                // If it is a moved learned by leveling up
                if (level > 0) {
                    moves.add(-1);
                    moves.add(-1);
                    moves.add(-1);
                    moves.add(-1);
                    moves.set(order-1,moveID);
                }
                // Move learned from TM, tutor, etc.
                else {
                    moves.add(moveID);
                }

                HashMap<Integer, ArrayList<Integer>> moveSet = new HashMap<>();
                moveSet.put(level, moves);
                PokemonMoveSet currentPokemon = new PokemonMoveSet(pokemonNumber, versionGroupID, moveSet,pokedexByNumber, moveService);
                moveMapping.put(pokemonNumber, currentPokemon);
            } else {
                PokemonMoveSet currentPokemon = moveMapping.get(pokemonNumber);

                // Add to current level list
                if (currentPokemon.getMoveMapping().get(level) != null) {
                    if (level > 0) {
                        currentPokemon.getMoveMapping().get(level).set(order - 1, moveID);
                    }
                    else {
                        currentPokemon.getMoveMapping().get(level).add(moveID);
                    }
                }
                // If move doesn't exist at level, create new level list
                else {
                    ArrayList<Integer> moves = new ArrayList<>();
                    if (order > 0) {
                        moves.add(-1);
                        moves.add(-1);
                        moves.add(-1);
                        moves.add(-1);
                        moves.set(order - 1, moveID);
                    }
                    else {
                        moves.add(moveID);
                    }
                    currentPokemon.getMoveMapping().put(level, moves);
                }
            }
        }
        return moveMapping;
    }

}