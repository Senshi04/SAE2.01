package Exceptions;

public class InvalidOrd extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrd() {
		super();
	}

	public String toString() {
		return "L'ordonn�e du point 1 doit �tre �gale � l'ordonn�e du point 3.";
	}

}
