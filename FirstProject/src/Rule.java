
public class Rule {

	private String binaryNum;
	private String decimalNum;
	
	public Rule(int decimalNum) {
		
		if(decimalNum >= 256 || decimalNum < 0) {
			
			System.out.println("Rule must be between 0 and 255.");
			System.out.println("Rule set to 0");
			
			this.binaryNum = String.format("%08d", Integer.parseInt(Integer.toBinaryString(22)));
			this.decimalNum = Integer.toString(0);
			
		}
		else {
			
			this.binaryNum = String.format("%08d", Integer.parseInt(Integer.toBinaryString(22)));
			this.decimalNum = Integer.toString(decimalNum);
		
		}
	}
	
	public boolean[] toBooleanArray() {
		
		boolean[] behaviorArray = new boolean[this.binaryNum.length()];
		
		for(int i = 0; i < behaviorArray.length; ++i) {
			
			behaviorArray[i] = (binaryNum.charAt(i) == '1');
			
		}
		
		return behaviorArray;
	}
	
}
