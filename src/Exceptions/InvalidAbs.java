package Exceptions;

public class InvalidAbs extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidAbs() {
		super();
	}
	public String toString() {
		return "L'abscisse du point 1 doit �tre �gale � celle du point 3 et celle du point 2 doit �tre inf�rieure";
	}
	
}
