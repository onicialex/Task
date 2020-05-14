import java.util.Stack;

public class EvaluateString {
	
	
	public int evaluateExpression(String expression) {
		
		char [] arrayExpression = expression.toCharArray();
		Stack<Integer> numberValues = new Stack<Integer>();
		Stack<Character>operationValues = new Stack<Character>();
		
		for(int i= 0;i<arrayExpression.length;i++) {
			if(arrayExpression[i] == ' ')
				continue;
			
			if(arrayExpression[i] >= '0' && arrayExpression[i] <= '9') {
				StringBuffer buffer = new StringBuffer();
				while(i< arrayExpression.length && arrayExpression[i] >= '0' && arrayExpression[i] <= '9') {
					buffer.append(arrayExpression[i++]);
				}
				numberValues.push(Integer.parseInt(buffer.toString()));
				
			}
			
			else if(arrayExpression[i] == '(') {
				operationValues.push(arrayExpression[i]);
			}
			
			else if(arrayExpression[i] == ')') {
				while(operationValues.peek() != '(') {
					numberValues.push(getResultOperation(operationValues.pop(), numberValues.pop(), numberValues.pop()));
				}
				operationValues.pop();
			}
			
			else if(arrayExpression[i] == '+' || arrayExpression[i] == '-' || arrayExpression[i] == '*' || arrayExpression[i] == '/') {
				while(!operationValues.empty() && verifieOperation(arrayExpression[i], operationValues.peek())) {
					numberValues.push(getResultOperation(operationValues.pop(), numberValues.pop(), numberValues.pop()));
				}
				operationValues.push(arrayExpression[i]);
					
			}
		}
		while(!operationValues.empty()) {
			numberValues.push(getResultOperation(operationValues.pop(),numberValues.pop() , numberValues.pop()));
		}
		return numberValues.pop();		
	}
	
	private int getResultOperation(char operation, int secondOperand, int firstOperand){ 
		switch(operation) {
		case '+':
			return firstOperand + secondOperand;
		case '-':
			return firstOperand-secondOperand;
		case '*':
			return firstOperand * secondOperand;
		case '/':
			if(secondOperand == 0)
				throw new ArithmeticException("Division by zero!");
			return firstOperand / secondOperand;
		}
		return 0;
	}
	
	private boolean verifieOperation(char firstOperation, char secondOperation) {
		if((secondOperation == '(') ||( secondOperation == ')'))
			return false;
		if((firstOperation == '*' || firstOperation == '/') &&(secondOperation == '+' || secondOperation == '-'))
			return false;
		else
			return true;
	}

}
