class Solution {

    Map<Character, char[]> keyboard = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
        );

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int startIdx, List<String> res, StringBuilder sb){

        if (startIdx == digits.length()) {

            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(startIdx);
        for (char ch : keyboard.get(digit)) {

            sb.append(ch);
            dfs(digits, startIdx +1, res, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
