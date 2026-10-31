class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] out = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        List<Integer>[] freqBucket = new ArrayList[nums.length +1];

        for (var entry : map.entrySet()) {

            int num = entry.getKey();
            int freq = entry.getValue();

            // No previous element with current "freq" was available
            if (freqBucket[freq] == null) {

                freqBucket[freq] = new ArrayList<>();
            }
            freqBucket[freq].add(num);
        }

        int count = 0;
        for (int i = freqBucket.length - 1; i >= 0; i--) {

            if (freqBucket[i] != null && count < k) {

                for (int num: freqBucket[i]) {

                    out[count]= num;
                    count++;

                    if (count >= k) break;
                }
            }
        }
        return out;
    }
}
