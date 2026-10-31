class Solution {
    public int characterReplacement(String s, int k) {

        int maxWin = 0; // Longest Substring
        int maxFreq = 0;
        int left = 0;

        int[] arr = new int[26]; // To store frequency of characters

        for (int right = 0; right < s.length(); right++) {

            arr[s.charAt(right) - 'A']++; // Calculate frequency of current character

            // Calculate maximum frequency as of now
            maxFreq = Math.max(maxFreq, arr[s.charAt(right) - 'A']);

            // Calculate current window as of now
            int currWin = right-left+1;

            // invalid window, bcz characters that can be replaced exceeds "k"
            if (currWin - maxFreq > k) {

                arr[s.charAt(left) - 'A']--; //reduce frequency of left pointer
                left++;

                currWin = right-left+1;
            }

            maxWin = Math.max(maxWin, currWin);
        }

        return maxWin;
        
    }
}
