package backtracking_回溯.递增子序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/12
 * Time: 18:37
 * Description: https://leetcode.cn/problems/non-decreasing-subsequences/
 */
public class main {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return res;
    }

    private void backTracing(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里不要加return，要取树上的节点
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            // 使用过当前数字
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.putIfAbsent(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }
    }
}
