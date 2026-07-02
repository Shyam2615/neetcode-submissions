class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num2 - num1;
                } else if (token.equals("*")) {
                    result = num1 * num2;
                } else {
                    result = num2 / num1;
                }
                stack.push(String.valueOf(result));

            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
