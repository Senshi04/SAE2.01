
public class InvalidOrd extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrd() {
		super();
	}

	public String toString() {
		return "L'ordonnée du point 1 doit être égale à l'ordonnée du point 3.";
	}

}
