package pl.rybak.pizzaaplication.domain.service;

import pl.rybak.pizzaaplication.domain.exeption.UnauthorizedExeption;

public class UnauthorizationService {

    public static void checkToken(String token){
        if(token == null || !token.equals("xzv")){
            throw new UnauthorizedExeption("Błędny token");
        }
    }
}
