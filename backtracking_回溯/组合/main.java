package backtracking_回溯.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/8
 * Time: 20:39
 * Description: https://leetcode.cn/problems/combinations/
 */
public class main {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backTracing(n, k, 1);

        return res;
    }

    private void backTracing(int n, int k, int start) {
        if (path.size() == k) {
            res.add((new ArrayList<>(path)));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracing(n, k, i + 1);
            path.removeLast();
        }
    }
}
