
public class Automaton {

	public Automaton(int ruleNum, boolean[] initState) {}
	
	public Automaton(String filename) {}
	
	public int getRuleNum() {
		
		return 0;
		
	}
	
	public void evolve(int steps) {}
	
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
