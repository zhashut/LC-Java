package hash_table_哈希表.两个数组的交集;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/16
 * Time: 22:09
 * Description: https://leetcode.cn/problems/intersection-of-two-arrays/submissions/
 */
public class main {
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] nums = new int[1000];
        for (int i = 0; i < nums1.length; i++) {
            nums[nums1[i]] = 1;
        }

        int[] tmp = new int[nums1.length];
        int len = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums[nums2[i]] == 1) {
                tmp[len++] = nums2[i];
                nums[nums2[i]] = 0;
            }
        }

        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp[i];
        }

        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        // 方法1：将结果集合转为数组
//        return resSet.stream().mapToInt(x -> x).toArray();

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            arr[j++] = i;
        }

        return arr;
    }
}
