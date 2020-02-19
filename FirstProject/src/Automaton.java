import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Automaton {

	private char falseSymbol;
	private char trueSymbol;
	private int ruleNum;
	private boolean[] initState;
	private int steps;
	private String generationsString = "";
	private String currentStateString = "";
	private boolean[] currentStateArray;
	private Generation initGeneration;
	private Rule ecaRule;
	
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
	
	public int getRuleNum() {
		return ruleNum;
	}
	
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
	
	public int getTotalSteps() {
		return this.steps;
	}
	
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
	
	@Override
	public String toString() {
		
		String replace = new String(this.generationsString);
		
		replace = replace.replace('0', getFalseSymbol());
		replace = replace.replace('1', getTrueSymbol());
		
		return replace;
	}
	
	public void save(String filename) throws IOException, FileNotFoundException {
		
		FileWriter writer = new FileWriter(new File(filename));
		
		writer.write(generationsString);
		
		writer.close();
	}
	
	public char getFalseSymbol() {
		return this.falseSymbol;
	}
	
	public void setFalseSymbol(char symbol) {
		this.falseSymbol = symbol;
	}
	
	public char getTrueSymbol() {
		return this.trueSymbol;
	}
	
	public void setTrueSymbol(char symbol) {
		this.trueSymbol = symbol;
	}
	
}
