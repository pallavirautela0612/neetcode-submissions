class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        String regex = "[0-9]";

        for (String str : tokens) {

            if (!isOperator(str)) {

                stack.push(Integer.valueOf(str));
            } else {

                int y = stack.pop();
                int x = stack.pop();
                int res = 0;

                if (str.equals("+")) {

                    res = x+y;
                } else if (str.equals("-")) {

                    res = x-y;
                } else if (str.equals("*")) {

                    res = x*y;
                } else if (str.equals("/")) {

                    res = x/y;
                }

                stack.push(res);
            }
        }

        return stack.peek();
    }

    private boolean isOperator(String str) {

        if (str.equals("+") ||
        str.equals("-") ||
        str.equals("*") ||
        str.equals("/")) {

            return true;
        } else {

            return false;
        }
    }
}
