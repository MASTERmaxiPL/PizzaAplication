package pl.rybak.pizzaaplication.domain.exeption;

public class UnauthorizedExeption extends RuntimeException{
    public UnauthorizedExeption(String message) { super(message);}
}
