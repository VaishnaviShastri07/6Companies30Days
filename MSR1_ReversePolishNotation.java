import java.util.Stack;

class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(applyOperator(token, x, y));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(String operator, int x, int y) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}








//Explanation
/*The Solution class provides a method evaluate that takes an array of strings tokens that represents an arithmetic expression in Reverse Polish Notation (RPN) and evaluates it.

The evalRPN method uses a stack to store the operands as it processes the RPN expression. It iterates through the tokens array and does the following for each token:

If the token is an operator, it pops the top two operands from the stack, applies the operator to them, and pushes the result back onto the stack.
If the token is not an operator, it parses it as an integer and pushes it onto the stack.
At the end of the iteration, the stack should have only one element left, which is the result of the RPN expression. The evaluate method returns this result by popping the top element from the stack.

The isOperator method is a helper method that returns true if the given token is one of the four basic arithmetic operators (+, -, *, /).

The applyOperator method is another helper method that takes an operator and two operands, applies the operator to the operands, and returns the result. 
It uses a switch statement to handle the different possible operators. If the operator is not recognized, it throws an IllegalArgumentException.*/
