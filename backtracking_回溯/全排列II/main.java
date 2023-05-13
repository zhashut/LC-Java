package backtracking_回溯.全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/13
 * Time: 19:46
 * Description: https://leetcode.cn/problems/permutations-ii/
 */
public class main {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(nums);
        return res;
    }

    private void backTracing(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true; // 标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                backTracing(nums);
                used[i] = false;
                path.removeLast(); // 回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
            }
        }
    }
}
