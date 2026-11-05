class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Followed hints in this solution:::
        // Sorting interval by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int lastEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int[] interval : intervals) {

            // non-overlapping
            if (lastEnd <= interval[0]) {

                lastEnd = interval[1];
            } else { // overlapping

                // If overlapping, take the end time that finishes early, 
                // it'll give more space to fit another interval (greedy approach)
                lastEnd = Math.min(lastEnd, interval[1]);
                count++;
            }
        }
        return count;
    }
}
