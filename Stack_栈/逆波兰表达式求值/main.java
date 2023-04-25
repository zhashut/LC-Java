package Stack_栈.逆波兰表达式求值;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/25
 * Time: 19:28
 * Description: https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class main {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> digitDeque = new ArrayDeque<>();
        ArrayDeque<String> strDeque = new ArrayDeque<>();
        int res = 0;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    int d1 = digitDeque.pop();
                    int d2 = digitDeque.pop();
                    res = d2 + d1;
                    digitDeque.push(res);
                    break;
                case "-":
                    d1 = digitDeque.pop();
                    d2 = digitDeque.pop();
                    res = d2 - d1;
                    digitDeque.push(res);
                    break;
                case "*":
                    d1 = digitDeque.pop();
                    d2 = digitDeque.pop();
                    res = d2 * d1;
                    digitDeque.push(res);
                    break;
                case "/":
                    d1 = digitDeque.pop();
                    d2 = digitDeque.pop();
                    res = d2 / d1;
                    digitDeque.push(res);
                    break;
                default:
                    digitDeque.push(Integer.valueOf(token));
                    break;
            }
        }

        return digitDeque.pop();
    }
}
