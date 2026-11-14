class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int startIdx, List<Integer> path) {

        res.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {

                path.add(nums[i]);
                dfs(nums, res, i +1, path);
                path.remove(path.size() -1);
        }
    }
}
