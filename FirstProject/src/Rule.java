/**
 * A class representing an elementary cellular automata rule.
 * 
 * @author Riley Draper
 * @version 1.0
 */
public class Rule {

	/**
	 * The rule in binary.
	 */
	private String binaryNum;
	
	/**
	 * The rule in decimal.
	 */
	private String decimalNum;
	
	/**
	 * Initialize a rule given a number in decimal.
	 * 
	 * @param decimalNum a number in decimal
	 */
	public Rule(int decimalNum) {
		
		if(decimalNum >= 256 || decimalNum < 0) {
			
			System.out.println("Rule must be between 0 and 255.");
			System.out.println("Rule set to 0");
			
			this.binaryNum = String.format("%08d", Integer.parseInt(Integer.toBinaryString(0)));
			this.decimalNum = Integer.toString(0);
			
		}
		else {
			
			this.binaryNum = String.format("%08d", Integer.parseInt(Integer.toBinaryString(decimalNum)));
			this.decimalNum = Integer.toString(decimalNum);
			
			
		}
	}
	
	/**
	 * Get a boolean array of length 8 which represents the rule of the elementary cellular automata.
	 * 
	 * @return a boolean array of the rule
	 */
	public boolean[] toBooleanArray() {
		
		boolean[] behaviorArray = new boolean[this.binaryNum.length()];
		
		for(int i = 0; i < behaviorArray.length; ++i) {
			
			behaviorArray[i] = (binaryNum.charAt(i) == '1');
			
		}
		
		return behaviorArray;
	}
	
	/**
	 * Get the binary number as a string.
	 * 
	 * @return the binary number as a string
	 */
	public String getString() {
		
		return this.binaryNum;
		
	}
	
}
