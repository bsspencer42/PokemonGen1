package Exceptions;

public class PokedexFileNotFoundException extends RuntimeException {
    public PokedexFileNotFoundException(String message){
        super(message);
    }
}
