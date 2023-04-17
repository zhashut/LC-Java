package hash_table_哈希表.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/17
 * Time: 20:23
 * Description: No Description
 */
public class main {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
