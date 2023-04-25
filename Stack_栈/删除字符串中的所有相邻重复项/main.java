package Stack_栈.删除字符串中的所有相邻重复项;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/25
 * Time: 18:49
 * Description: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */
public class main {

    public static void main(String[] args) {
        String s = "abbaca";
        removeDuplicates(s);
    }

    public static String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            if (deque.isEmpty() || deque.peek() != ch[i]) {
                deque.push(ch[i]);
            } else {
                deque.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pop());
        }

        return res.toString();
    }

    public String removeDuplicates2(String s) {
        // 将 res 当做栈
        // 也可以用 StringBuilder 来修改字符串，速度更快
        // StringBuilder res = new StringBuilder();
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
