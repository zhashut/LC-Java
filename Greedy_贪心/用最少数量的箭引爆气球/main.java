package Greedy_贪心.用最少数量的箭引爆气球;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/20
 * Time: 11:29
 * Description: https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class main {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;

    }
}
