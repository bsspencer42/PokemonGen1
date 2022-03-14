package Services;

import DAO.MoveDAO;
import DAO.PokemonDAO;
import Pokemon.Pokemon;
import Pokemon.PokemonBase;
import Pokemon.PokemonMoveSet;

import java.util.HashMap;

public class PokemonService {
    private HashMap<String, PokemonBase> pokedex;
    private HashMap<Integer,PokemonBase> pokedexByNumber;
    private EvolutionService evolutionService;
    private MoveService moveService;
    private HashMap<Integer, PokemonMoveSet> moveMapping;

    public PokemonService(){
        this.pokedex = PokemonDAO.pokedexInitialize("pokemonComplete.csv");
        this.pokedexByNumber = PokemonDAO.pokedexByNumber(pokedex);
        this.evolutionService = new EvolutionService("gen1Evolutions.csv");
        this.moveService = new MoveService("moves.csv");
        this.moveMapping = MoveDAO.moveMapping("pokemonMovesGen1.csv",pokedexByNumber, moveService);

    }

    public HashMap<String, PokemonBase> getPokedex() {
        return pokedex;
    }

    public HashMap<Integer, PokemonBase> getPokedexByNumber() {
        return pokedexByNumber;
    }

    public PokemonBase getPokemonBase(String name){
        return pokedex.get(name);
    }

    public Pokemon getPokemon(String name, int level){
        return new Pokemon(pokedex.get(name),level,evolutionService, this);
    }

    public HashMap<Integer, PokemonMoveSet> getMoveMapping() {
        return moveMapping;
    }

    public EvolutionService getEvolutionService() {
        return evolutionService;
    }

    public MoveService getMoveService() {
        return moveService;
    }
}
