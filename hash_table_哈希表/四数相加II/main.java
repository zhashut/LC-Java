package hash_table_哈希表.四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/17
 * Time: 23:15
 * Description: https://leetcode.cn/problems/4sum-ii/
 */
public class main {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                int tmp = i + j;
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp)+1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int tmp = i + j;
                if (map.containsKey(0 - tmp)) {
                    res += map.get(0 - tmp);
                }
            }
        }

        return res;
    }
}
