package Greedy_贪心.单调递增的数字;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/22
 * Time: 5:43
 * Description: https://leetcode.cn/problems/partition-labels/
 */
public class main {
    // 解法一
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 1; i >= 1; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                start = i;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    // 解法二
    public int monotoneIncreasingDigits2(int n) {
        String[] strings = (n + "").split("");
        int start = strings.length;

        for (int i = strings.length - 1; i >= 0; i--) {
            if (Integer.parseInt(strings[i - 1]) > Integer.parseInt(strings[i])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }

        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }


        return Integer.parseInt(String.join("", strings));
    }
}
