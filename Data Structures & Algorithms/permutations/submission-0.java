class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, res, new ArrayList<>(), used);
        
        return res;
    }

    private void dfs(int[] nums, int startIdx, List<List<Integer>> res, 
                    List<Integer> path, boolean[] used) {

        // 'startIdx' only tracks how many slots we have filled so far.
        if (startIdx == nums.length) {

            res.add(new ArrayList<>(path));
            return;
        }

        // Unlike combinations (which advance a lower bound to avoid order duplicates),
        // permutations scan from index 0 every time so any unused element can fill 'startIdx'.
        for (int i = 0; i < nums.length; i++) {

            // Skip elements already placed in the current 'path',
            // to prevent reusing the same index.
            if (used[i] == true) continue;

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, startIdx+1, res, path, used);

            // Un-choose (Backtrack): Remove the last element and free index i so other branches
            // at this recursion level can try placing nums[i] in this slot instead.
            path.remove(path.size() -1);
            used[i] = false;
        }
    }
}
