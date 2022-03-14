package PalletTown;

import DAO.EvolutionDAO;
import DAO.MoveDAO;
import DAO.PokemonDAO;
import Pokemon.Pokemon;
import Services.EvolutionService;
import Services.MoveService;
import Services.PokemonService;
import Pokemon.PokemonMoveSet;

public class PalletTown {

    public static void main(String[] args) {
        // Let it rip!
        PokemonService pokedex = new PokemonService();


        Pokemon pokemon1 = pokedex.getPokemon("Charmander",15);
        System.out.println(pokemon1.toString());
        System.out.println(pokemon1.gainExperience(500));
        System.out.println(pokemon1.toString());
        System.out.println(pokemon1.gainExperience(15));
        System.out.println(pokemon1.toString());
    }

}
