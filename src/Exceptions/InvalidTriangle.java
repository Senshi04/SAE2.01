package Exceptions;

public class InvalidTriangle extends Exception{
    public InvalidTriangle(){
        super();
    }
    public String toString(){
        return "Le triangle que vous avez tenté de créer est invalide";
    }
}
