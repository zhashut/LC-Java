package backtracking_回溯.组合总和III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/8
 * Time: 20:54
 * Description: https://leetcode.cn/problems/combination-sum-iii/
 */
public class main {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracing(k, n, 0, 1);

        return res;
    }

    private void backTracing(int k, int n, int sum, int start) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (sum + i > n || 9 - i + 1 < k - path.size()) {
                break;
            }
            path.add(i);
            backTracing(k, n, sum + i, i + 1);
            path.removeLast();
        }
    }
}
