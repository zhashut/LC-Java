package backtracking_回溯.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/12
 * Time: 17:45
 * Description: https://leetcode.cn/problems/subsets-ii/
 */
public class main {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>(path));
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(nums, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
