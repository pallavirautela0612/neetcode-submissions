class Solution {

    // Same as "Subsets" problem with dedup logic
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // Group duplicates together so same-level branches can be skipped cleanly.
        Arrays.sort(nums); 
        dfs(nums, 0, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int startIdx, List<List<Integer>> res, List<Integer> path) {

        // Save a snapshot of the current subset before exploring further.
        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {

            // Skip duplicate choices at this same slot, to prevent duplicate branches
            if (i > startIdx && nums[i] == nums[i-1]) continue;

            path.add(nums[i]);
            dfs(nums, i+1, res, path);
            path.remove(path.size() -1);
        }
    }
}
