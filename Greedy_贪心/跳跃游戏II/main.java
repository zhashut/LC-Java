package Greedy_贪心.跳跃游戏II;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/17
 * Time: 19:58
 * Description: https://leetcode.cn/problems/jump-game-ii/
 */
public class main {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int curDistance = 0, nextDistance = 0, result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {
                result++;
                curDistance = nextDistance;
            }
        }

        return result;
    }
}
