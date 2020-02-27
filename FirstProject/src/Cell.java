/**
 * A class representing a single cell.
 * 
 * @author Riley Draper
 * @version 1.0
 *
 */
public class Cell {

	/**
	 * The current state of the cell.
	 */
	private boolean state;
	
	/**
	 * Constructor initializing the cell to a given state.
	 * @param state state of cell
	 */
	public Cell(boolean state) {
		this.state = state;
	}
	
	/**
	 * Get state of cell as a boolean value.
	 * 
	 * @return state of cell
	 */
	public boolean getState() {
		return this.state;
	}
	
}
