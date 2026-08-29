class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            int y;
            int x;
            switch (token) {
                case "+":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x + y);
                    break;
                case "-":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x - y);
                    break;
                case "*":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x * y);
                    break;
                case "/":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x / y);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
