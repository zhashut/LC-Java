package backtracking_回溯.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/11
 * Time: 20:18
 * Description: https://leetcode.cn/problems/subsets/
 */
public class main {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTracing(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
