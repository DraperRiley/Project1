import java.util.ArrayList;


public class Generation {

	private ArrayList<Cell> ecaGeneration;
	private String generationString = "";
	private boolean[] generationArray;
	
	public Generation(boolean[] initState) {
		
		ecaGeneration =  new ArrayList<Cell>();
		
		for(int i = 0; i < initState.length; ++i) {
			
			ecaGeneration.add(new Cell(initState[i]));
		
		}
		
	}
	
	public Cell getCell(int index) {
		return ecaGeneration.get(index);
	}
	
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
	
	public boolean[] toBooleanArray() {
		
		generationArray = new boolean[ecaGeneration.size()];
		
		for(int i = 0; i < generationArray.length; ++i) {
			generationArray[i] = ecaGeneration.get(i).getState();
		}
		
		return generationArray;
	}
	
}
