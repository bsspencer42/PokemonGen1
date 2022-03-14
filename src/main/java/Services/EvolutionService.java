package Services;

import DAO.EvolutionDAO;
import Pokemon.Evolution;

import java.util.HashMap;

public class EvolutionService {

    private HashMap<Integer, Evolution> evolutionHashMap;

    public EvolutionService(String fileName){
        this.evolutionHashMap = EvolutionDAO.evolutionInitialize(fileName);
    }

    public Evolution getEvolution(int pokemonNumber){
       return evolutionHashMap.get(pokemonNumber);
    }

    // Methods

    public boolean evolvesNextLevel(int pokemonNumber, int nextLevel){
        Evolution pokemonEvo = evolutionHashMap.get(pokemonNumber);
        // If Pokemon does not have evolution
        if (pokemonEvo == null || pokemonEvo.isTrade() == true || pokemonEvo.getStone().size() > 0){
            return false;
        }
        // If next level is evo level
        else if (pokemonEvo.getLevel() <= nextLevel){
            return true;
        }
        // Not eligible yet
        else {
            return false;
        }
    }

}
