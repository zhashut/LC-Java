package backtracking_回溯.分割回文串;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/10
 * Time: 20:04
 * Description: https://leetcode.cn/problems/palindrome-partitioning/
 */
public class main {
    List<List<String>> res;
    List<String> path;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backTracing(s, 0);
        return res;
    }

    private void backTracing(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            backTracing(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
