package Greedy_贪心.加油站;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/18
 * Time: 21:26
 * Description: https://leetcode.cn/problems/gas-station/
 */
public class main {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        int tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if (gasSum - costSum < 0) {
            return -1;
        }

        return start;
    }
}
