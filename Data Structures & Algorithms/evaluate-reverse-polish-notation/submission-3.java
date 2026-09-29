class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int output = 0;

        if(tokens.length ==1){
            return Integer.parseInt(tokens[0]);
        }

        for (String s : tokens) {
            if (!s.equals("-") && !s.equals("+") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+":
                        output = a + b;
                        stack.push(String.valueOf(output));
                        break;

                    case "-":
                        output = b - a;
                        stack.push(String.valueOf(output));
                        break;

                    case "*":
                        output = a * b;
                        stack.push(String.valueOf(output));
                        break;

                    case "/":
                        output = b / a;
                        stack.push(String.valueOf(output));
                        break;
                }
            }
        }
        return output;
    }
}
