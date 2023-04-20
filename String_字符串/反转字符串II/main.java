package String_字符串.反转字符串II;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/20
 * Time: 19:39
 * Description: https://leetcode.cn/problems/reverse-string-ii/
 */
public class main {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            // 这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);

            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

        return new String(ch);
    }
}
