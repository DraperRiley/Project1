
public class Driver {

	public static void main(String[] args) {
		
		Rule rule22 = new Rule(22);
		boolean[] rule22Array = rule22.toBooleanArray();
		
		System.out.println(String.format("%08d", Integer.parseInt(Integer.toBinaryString(22))));
		
		for(int i = 0; i < rule22Array.length; ++i) {
			System.out.println(rule22Array[i]);
			
			
		}
		
	}
	
}
