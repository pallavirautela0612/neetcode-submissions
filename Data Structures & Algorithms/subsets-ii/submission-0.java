class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int startIdx, List<List<Integer>> res, List<Integer> path) {

        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {

            if (i > startIdx && nums[i] == nums[i-1]) continue;

            path.add(nums[i]);
            dfs(nums, i+1, res, path);
            path.remove(path.size() -1);
        }
    }
}
