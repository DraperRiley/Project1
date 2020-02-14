import java.util.ArrayList;


public class Generation {

	private ArrayList<Cell> ecaGeneration;
	private String generationString;
	
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
			
			if(ecaGeneration.get(i).getState() == true) {
				generationString += "1";
			}
			else {
				generationString += "0";
			}
			
		}
		
		
		return generationString;
	}
	
}
