

public class Main {
	public static void main(String [] args) {
		
		EvaluateString expression = new EvaluateString();
		System.out.println("Result of  2 + 4 = " + expression.evaluateExpression("2 + 4"));
		System.out.println("Result of 15 + 2 * 5 = " + expression.evaluateExpression("15 + 2 * 5"));
	    System.out.println("Result of 4 * ( 2 + 13 ) / 10 = " +expression.evaluateExpression("4 * ( 2 + 13 ) / 10")); 
	}

}
