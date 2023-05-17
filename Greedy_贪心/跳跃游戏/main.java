package Greedy_贪心.跳跃游戏;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/17
 * Time: 19:22
 * Description: https://leetcode.cn/problems/jump-game/
 */
public class main {
    public static boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
