package backtracking_回溯.组合总和II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/9
 * Time: 19:30
 * Description: https://leetcode.cn/problems/combination-sum-ii/
 */
public class main {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracing(candidates, target, 0, 0);
        return res;
    }

    private void backTracing(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backTracing(candidates, target, sum + candidates[i], i + 1);
            path.removeLast();
        }
    }
}
