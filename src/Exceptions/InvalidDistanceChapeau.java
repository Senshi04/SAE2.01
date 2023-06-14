package Exceptions;

public class InvalidDistanceChapeau extends Exception {
	public InvalidDistanceChapeau(){
		super();
	}
	
	public String toString() {
		return "La distance entre p1 et p3 est invalide. \nIl faut que la distance entre p1 et p2 soit la m�me entre p2 et p3 !";
	}

}
