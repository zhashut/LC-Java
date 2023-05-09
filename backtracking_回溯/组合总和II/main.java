package backtracking_回溯.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
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
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);

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
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            used[i] = true;
            backTracing(candidates, target, sum + candidates[i], i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
