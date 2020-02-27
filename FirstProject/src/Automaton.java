import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * A class used to create Elementary Cellular Automata using a collection of classes.
 * Automata class is used to create and evolve the Elementary Cellular Automata as well
 * as get various information.
 * @author Riley Draper
 * @version 1.0
 *
 */

public class Automaton {

	/**
	 * The false symbol. Can be chosen.
	 */
	private char falseSymbol;
	
	/**
	 * The true symbol. Can be chosen.
	 */
	private char trueSymbol;
	
	/**
	 * The number from 0 to 255 that determines the evolutionary pattern of the Automata.
	 */
	private int ruleNum;
	
	/**
	 * A boolean array used to set the initial state of the "Zero" evolution. True is black, false is white.
	 */
	private boolean[] initState;
	
	/**
	 * A counter that keeps track of the total steps.
	 */
	private int steps;
	
	/**
	 * A String that contains all the evolutions on separate lines.
	 */
	private String generationsString = "";
	
	/**
	 * A string that holds the current generation. Currently unused.
	 */
	private String currentStateString = "";
	
	/**
	 * A boolean array that holds the current state using true and false values. True is black, false is white.
	 */
	private boolean[] currentStateArray;
	
	/**
	 * A Generation type that contains the current generation of cellular automata.
	 */
	private Generation initGeneration;
	
	/**
	 * Uses the rule class to store the rule which defines the cellular automata.
	 */
	private Rule ecaRule;
	
	/**
	 * Constructor which initializes an automata using a rule and an array of type boolean representing the initial state of generation zero.
	 * 
	 * @param ruleNum the rule number from 0 to 255 that dictates the behavior of the automata
	 * @param initState initial state of the zero generation
	 */
	public Automaton(int ruleNum, boolean[] initState) {
		
		this.ruleNum = ruleNum;
		this.ecaRule = new Rule(ruleNum);
		this.initState = initState;
		this.falseSymbol = '0';
		this.trueSymbol = '1';
		this.initGeneration = new Generation(initState);
		this.generationsString += this.initGeneration.getGenerationString();
		this.currentStateString = this.initGeneration.getGenerationString();
		this.currentStateArray = initGeneration.toBooleanArray();
		
		
	}
	
	/**
	 * Creates an automata using information from a file.
	 * 
	 * @param filename the name of the file including the file extension
	 * @throws FileNotFoundException thrown if file cannot be opened
	 * @throws IOException thrown if Scanner cannot be used
	 */
	public Automaton(String filename) throws FileNotFoundException, IOException {
		
		Scanner reader = new Scanner(new FileReader(filename));
		
		this.ruleNum = Integer.parseInt(reader.nextLine());
		ecaRule = new Rule(ruleNum);
		String symbolString = reader.nextLine();
		this.falseSymbol = symbolString.split(" ")[0].charAt(0);
		this.trueSymbol = symbolString.split(" ")[1].charAt(0);
		
		String initStateString = reader.nextLine();
		this.initState = new boolean[initStateString.length()];
		
		for(int i = 0; i < initState.length; ++i) {
			
			if(initStateString.charAt(i) == trueSymbol) {
				this.initState[i] = true;
			}
			else {
				this.initState[i] = false;
			}
			
		}
		
		reader.close();
		this.initGeneration = new Generation(initState);
		this.generationsString += this.initGeneration.getGenerationString();
		this.currentStateString = this.initGeneration.getGenerationString();
		this.currentStateArray = initGeneration.toBooleanArray();
		
	}
	
	/**
	 * Returns the rule number
	 * @return the rule number of the automata
	 */
	public int getRuleNum() {
		return ruleNum;
	}
	
	/**
	 * Evolves the automata a given number of steps.
	 * @param steps the number of steps to evolve the automata
	 */
	public void evolve(int steps) {
		
		this.steps += steps;
		int leftIndex;
		int rightIndex;
		Generation prevGeneration;
		boolean[] newState = new boolean[this.currentStateArray.length];
		Generation newGeneration;
		
		
		for(int i = 0; i < steps; i++) {
			
			prevGeneration = new Generation(this.currentStateArray);
			
			for(int j = 0; j < currentStateArray.length; ++j) {
				
				
				
				if(j == 0) {
					leftIndex = newState.length - 1;
					rightIndex = j + 1;
				}
				else if(j == newState.length - 1) {
					leftIndex = j - 1;
					rightIndex = 0;
				}
				else {
					leftIndex = j - 1;
					rightIndex = j + 1;
				}
				
				
				
				if(prevGeneration.getCell(leftIndex).getState() == true && prevGeneration.getCell(j).getState() == true && prevGeneration.getCell(rightIndex).getState() == true) {
					currentStateArray[j] = (ecaRule.getString().charAt(0) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == true && prevGeneration.getCell(j).getState() == true && prevGeneration.getCell(rightIndex).getState() == false) {
					currentStateArray[j] = (ecaRule.getString().charAt(1) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == true && prevGeneration.getCell(j).getState() == false && prevGeneration.getCell(rightIndex).getState() == true) {
					currentStateArray[j] = (ecaRule.getString().charAt(2) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == true && prevGeneration.getCell(j).getState() == false && prevGeneration.getCell(rightIndex).getState() == false) {
					currentStateArray[j] = (ecaRule.getString().charAt(3) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == false && prevGeneration.getCell(j).getState() == true && prevGeneration.getCell(rightIndex).getState() == true) {
					currentStateArray[j] = (ecaRule.getString().charAt(4) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == false && prevGeneration.getCell(j).getState() == true && prevGeneration.getCell(rightIndex).getState() == false) {
					currentStateArray[j] = (ecaRule.getString().charAt(5) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == false && prevGeneration.getCell(j).getState() == false && prevGeneration.getCell(rightIndex).getState() == true) {
					currentStateArray[j] = (ecaRule.getString().charAt(6) == '1');
				}
				else if(prevGeneration.getCell(leftIndex).getState() == false && prevGeneration.getCell(j).getState() == false && prevGeneration.getCell(rightIndex).getState() == false) {
					currentStateArray[j] = (ecaRule.getString().charAt(7) == '1');
				}
				
				
			}
			
			newGeneration = new Generation(this.currentStateArray);
			this.generationsString += "\n" +newGeneration.getGenerationString();
			this.currentStateString = newGeneration.getGenerationString();
			
		}
		
	}
	
	/**
	 * Gets the total number of steps the automata has been evolved.
	 * @return int value representing total number of steps
	 */
	public int getTotalSteps() {
		return this.steps;
	}
	
	
	/**
	 * Gets a boolean array representing the automata at a given step.
	 * 
	 * @param stepNum step num to get state of
	 * @return boolean array representing the state at that step
	 */
	public boolean[] getState(int stepNum) {
		
		Scanner stepScan = new Scanner(generationsString);
		String stepString = "";
		
		for(int i = 0; i <= stepNum; ++i) {
			stepString = stepScan.nextLine();
		}
		
		boolean[] stepBool = new boolean[stepString.length()];
		
		for(int i = 0; i < stepBool.length; ++i) {
			stepBool[i] = (stepString.charAt(i) == '1');
		}
		
		stepScan.close();
		
		return stepBool;
	}
	
	/**
	 * Gets the state of the automata at a given step as a string.
	 * 
	 * @param stepNum int desired step
	 * @return A string representing the state at a given step
	 */
	public String getStateString(int stepNum) {
		
		Scanner stepScan = new Scanner(generationsString);
		String stepString = "";
		
		for(int i = 0; i <= stepNum; ++i) {
			stepString = stepScan.nextLine();
		}
		
		stepString = stepString.replace('0', getFalseSymbol());
		stepString = stepString.replace('1', getTrueSymbol());
		
		stepScan.close();
		
		return stepString;
	}
	
	/**
	 * Returns a string of all generations using the given true and false symbols.
	 */
	@Override
	public String toString() {
		
		String replace = new String(this.generationsString);
		
		replace = replace.replace('0', getFalseSymbol());
		replace = replace.replace('1', getTrueSymbol());
		
		return replace;
	}
	
	/**
	 * Saves all evolutions of the automata to a given file.
	 * 
	 * @param filename name of file including extension
	 * @throws IOException if FileWriter encounters error
	 * @throws FileNotFoundException if file cannot be opened
	 */
	public void save(String filename) throws IOException, FileNotFoundException {
		
		FileWriter writer = new FileWriter(new File(filename));
		
		writer.write(generationsString);
		
		writer.close();
	}
	
	/**
	 * Returns the given false symbol. Default 0.
	 * 
	 * @return the false symbol as a char
	 */
	public char getFalseSymbol() {
		return this.falseSymbol;
	}
	
	/**
	 * Set the false symbol to a desired character.
	 * 
	 * @param symbol desired char
	 */
	public void setFalseSymbol(char symbol) {
		this.falseSymbol = symbol;
	}
	
	/**
	 * Return the given true symbol. Default 1.
	 * 
	 * @return the true symbol as a char
	 */
	public char getTrueSymbol() {
		return this.trueSymbol;
	}
	
	/**
	 * Set the true symbol to a desired character.
	 * 
	 * @param symbol desired char
	 */
	public void setTrueSymbol(char symbol) {
		this.trueSymbol = symbol;
	}
	
}
