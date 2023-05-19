package Greedy_贪心.柠檬水找零;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/19
 * Time: 19:37
 * Description: https://leetcode.cn/problems/lemonade-change/
 */
public class main {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            }
            if (bills[i] == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else if (five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
