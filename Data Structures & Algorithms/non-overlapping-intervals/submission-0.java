class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int lastEnd = Integer.MIN_VALUE;
        int count = 0;

        for (int[] interval : intervals) {

            if (lastEnd <= interval[0]) {

                lastEnd = interval[1];
            } else {

                count++;
            }
        }
        return count;
    }
}
