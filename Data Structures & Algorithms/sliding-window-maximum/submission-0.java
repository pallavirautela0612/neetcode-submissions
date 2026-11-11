class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<List<Integer>> maxHeap = 
                            new PriorityQueue<>((a,b) -> Integer.compare(b.get(0), a.get(0)));
        List<Integer> res = new ArrayList<>();

        // First Window of size k
        for (int i = 0; i < k; i++) {

            maxHeap.add(List.of(nums[i], i));
        }
        res.add(maxHeap.peek().get(0));

        // Sliding window from here
        for (int right = k; right < nums.length; right++) {

            // Left is excluded in the current boundary
            int left = right - k; 

            maxHeap.add(List.of(nums[right], right));

            while (maxHeap.peek().get(1) <= left) {

                maxHeap.poll();
            }

            res.add(maxHeap.peek().get(0));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
