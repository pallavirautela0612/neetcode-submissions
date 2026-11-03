class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty()) {
                if (isPair(stack.peek(), ch)) {

                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }

    private boolean isPair(char ch1, char ch2) {

        if (ch1 == '(' && ch2 == ')' ||
        ch1 == '{' && ch2 == '}'||
        ch1 == '[' && ch2 == ']') {

            return true;
        }
        return false;
    }
}
