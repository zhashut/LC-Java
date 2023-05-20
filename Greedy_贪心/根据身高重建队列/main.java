package Greedy_贪心.根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/20
 * Time: 10:45
 * Description: https://leetcode.cn/problems/queue-reconstruction-by-height/
 */
public class main {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 先按照 people[1] 来排序，再比较
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });


        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }
}
