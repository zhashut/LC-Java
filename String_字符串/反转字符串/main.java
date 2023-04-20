package String_字符串.反转字符串;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/20
 * Time: 19:19
 * Description: https://leetcode.cn/problems/reverse-string/
 */
public class main {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }

    }
}
