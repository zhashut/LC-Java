package backtracking_回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/10
 * Time: 19:05
 * Description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class main {
    List<String> res;
    String[] m;
    StringBuilder path;

    public List<String> letterCombinations(String digits) {
        m = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res = new ArrayList<>();
        path = new StringBuilder();
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int index) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String str = m[digit - 2];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            dfs(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
