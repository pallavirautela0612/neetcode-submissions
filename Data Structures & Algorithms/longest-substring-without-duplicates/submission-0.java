class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int left = 0; int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {

            while (set.contains(s.charAt(right))) {

                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);

            right++;
        }
        return maxLen;
    }
}
