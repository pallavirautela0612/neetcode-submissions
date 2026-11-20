class Solution {

    /* Almost same as Combination Sum, just skip duplicate branches
        by checking adjacent duplicate elements after sorting.
    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Sort so duplicate values sit next to each other, making duplicate-skipping
        // and early pruning straightforward.
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, 0, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] candidates, int target, int startIdx, 
                    List<List<Integer>> res, List<Integer> path) {

        // Prune dead ends where the remaining target has been exceeded.                
        if (target < 0) return;

        // Found a valid combination; store a copy since 'path' is mutated in place.
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i < candidates.length; i++) {

            // Skip duplicate values at the SAME recursion depth (i > startIdx) so we
            // don't start redundant branches with the same number at this slot.
            // When i == startIdx in a deeper call, we still allow picking a duplicate
            // value from the array (e.g., forming [1, 1] from [1, 1, 2]), which is allowed.
            if (i > startIdx && candidates[i] == candidates[i-1]) continue;

            path.add(candidates[i]);

            // (StartIdx = i + 1) since each element can be used at most once.
            dfs(candidates, target - candidates[i], i+1, res, path); 
            path.remove(path.size()-1);
        }
    }
}
