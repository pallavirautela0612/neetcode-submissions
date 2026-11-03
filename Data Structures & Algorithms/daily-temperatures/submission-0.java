class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int[] res = new int[temp.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temp.length -1; i >= 0; i--) {

            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {

                res[i] = 0;
            } else {

                res[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return res;
    }
}
