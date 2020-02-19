
public class Driver {

	public static void main(String[] args) {
		
		
		
		Rule rule22 = new Rule(115);
		boolean[] rule22Array = rule22.toBooleanArray();
		
		//System.out.println(String.format("%08d", Integer.parseInt(Integer.toBinaryString(22))));
		
		for(int i = 0; i < rule22Array.length; ++i) {
			//System.out.println(rule22Array[i]);
			
		
		}
		
		//System.out.println(rule22.getString());
		
		//Generation newGen = new Generation(rule22Array);
		//System.out.println(newGen.getGenerationString());
	
		for(int i = 0; i < rule22Array.length; ++i) {
			//System.out.println(newGen.getCell(i).getState());
		}
		
		boolean[] init = {false, false, true, false, true, true, true, true, true, true, false};
		
		Automaton myAut = new Automaton(115, init);
		
		myAut.setFalseSymbol('.');
		myAut.setTrueSymbol('$');
		
		//System.out.println(Integer.toBinaryString(115));
		//System.out.println(String.format("%08d", Integer.parseInt(Integer.toBinaryString(115))));
		
		System.out.println(myAut.toString());
		
		myAut.evolve(3);
		
		System.out.println(myAut.toString());
		
		System.out.println(myAut.getTotalSteps());
	}
	
}
