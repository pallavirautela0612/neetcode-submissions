class Solution {
    public boolean checkInclusion(String s1, String s2) {

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            
            if (isAnagram(s1, s2.substring(i, i + s1. length()))) {

                return true;
            }
        }
       return false; 
    }

    public boolean isAnagram(String str1, String str2) {

        int[] arr = new int[26];

        for (char ch : str1.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (char ch: str2.toCharArray()) {
            arr[ch - 'a']--;
        }

        for (int num : arr) {
            if (num != 0) return false;
        }

        return true;
    }
}
