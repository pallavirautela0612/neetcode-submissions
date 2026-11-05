class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {

            int lastIdx  = res.size() -1;
            if (res.isEmpty() || res.get(lastIdx)[1] < interval[0]) {

                res.add(interval);
            } else {

                int[] lastInterval = res.get(lastIdx);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        return res.toArray(int[][] :: new);
    }
}
