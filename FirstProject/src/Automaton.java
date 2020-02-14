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
	
	public Automaton(int ruleNum, boolean[] initState) {
		
		this.ruleNum = ruleNum;
		this.initState = initState;
		this.falseSymbol = '0';
		this.trueSymbol = '1';
		
	}
	
	public Automaton(String filename) throws FileNotFoundException, IOException {
		
		Scanner reader = new Scanner(new FileReader(filename));
		
		ruleNum = Integer.parseInt(reader.nextLine());
		String symbolString = reader.nextLine();
		falseSymbol = symbolString.split(" ")[0].charAt(0);
		trueSymbol = symbolString.split(" ")[1].charAt(0);
		
		String initStateString = reader.nextLine();
		initState = new boolean[initStateString.length()];
		
		for(int i = 0; i < initState.length; ++i) {
			
			if(initStateString.charAt(i) == trueSymbol) {
				initState[i] = true;
			}
			else {
				initState[i] = false;
			}
			
		}
		
	}
	
	public int getRuleNum() {
		return ruleNum;
	}
	
	public void evolve(int steps) {
		
		int leftIndex;
		int rightIndex;
		
		for(int i = 0; i < steps; i++) {
			
			//for(int j = 0; j < )
			
			
		}
		
	}
	
	public int getTotalSteps() {
		
		return 0;
		
	}
	
	public boolean[] getState() {
		return null;
	}
	
	public String getStateString(int stepNum) {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
	public void save(String filename) {}
	
	public char getFalseSymbol() {
		return 'a';
	}
	
	public void setFalseSymbol(char symbol) {}
	
	public char getTrueSymbol() {
		return 'a';
	}
	
	public void setTrueSymbol(char symbol) {}
	
}
