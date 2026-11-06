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

        dfs(digits, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(String digits, int startIdx, List<String> res, List<Character> path){

        if (startIdx == digits.length()) {

            String str = path.stream().map(e -> e.toString()).collect(Collectors.joining());
            res.add(str);
            return;
        }

        char digit = digits.charAt(startIdx);
        for (char ch : keyboard.get(digit)) {

            path.add(ch);
            dfs(digits, startIdx +1, res, path);
            path.remove(path.size() -1);
        }
    }
}
