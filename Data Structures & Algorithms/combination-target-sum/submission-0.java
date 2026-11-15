class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int startIdx, List<List<Integer>> res, 
                                                            List<Integer> path) {
        
        if (target < 0) return;
        if (target == 0) {

            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
    
            path.add(nums[i]);
            dfs(nums, target-nums[i], i, res, path);
            path.remove(path.size() -1);
        }
    }
}
