package Greedy_贪心.分发饼干;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/15
 * Time: 19:12
 * Description: https://leetcode.cn/problems/assign-cookies/
 */
public class main {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0, index = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }

        return result;
    }
}
