package Greedy_贪心.分发糖果;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/19
 * Time: 19:02
 * Description: https://leetcode.cn/problems/candy/
 */
public class main {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        candy(ratings);
    }

    public static int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        Arrays.fill(candyVec, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyVec[i] = candyVec[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < candyVec.length; i++) {
            sum += candyVec[i];
        }

        return sum;
    }
}
