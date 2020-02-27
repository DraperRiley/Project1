import java.util.ArrayList;

/**
 * A class representing a generation of boolean values representing a step of an automata.
 * @author Riley Draper
 * @version 1.0
 */
public class Generation {

	/**
	 * An ArrayList of cells.
	 */
	private ArrayList<Cell> ecaGeneration;
	
	/**
	 * A string representing the state of the generation.
	 */
	private String generationString = "";
	
	/**
	 * A boolean array representing the state of the generation.
	 */
	private boolean[] generationArray;
	
	/**
	 * Initialize a generation given a boolean array.
	 * 
	 * @param initState boolean[] array representing the state of cells.
	 */
	public Generation(boolean[] initState) {
		
		ecaGeneration =  new ArrayList<Cell>();
		
		for(int i = 0; i < initState.length; ++i) {
			
			ecaGeneration.add(new Cell(initState[i]));
		
		}
		
	}
	
	/**
	 * Returns a Cell at a given index in the generation.
	 * 
	 * @param index location of desired cell
	 * @return a cell at given index
	 */
	public Cell getCell(int index) {
		return ecaGeneration.get(index);
	}
	
	/**
	 * Get a string representing the states of the generation.
	 * 
	 * @return a String of the generation
	 */
	public String getGenerationString() {
		
		for(int i = 0; i < ecaGeneration.size(); ++i) {
			
			if(ecaGeneration.get(i).getState() == false) {
				generationString += "0";
			}
			else {
				generationString += "1";
			}
			
		}
		
		
		return generationString;
	}
	
	/**
	 * Get a boolean array of the generation.
	 * 
	 * @return a boolean array
	 */
	public boolean[] toBooleanArray() {
		
		generationArray = new boolean[ecaGeneration.size()];
		
		for(int i = 0; i < generationArray.length; ++i) {
			generationArray[i] = ecaGeneration.get(i).getState();
		}
		
		return generationArray;
	}
	
}
