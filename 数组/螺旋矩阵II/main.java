package 数组.螺旋矩阵II;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/12
 * Time: 8:56
 * Description: https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class main {
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) {
            // 从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            // 从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            // 从左到右
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            // 从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
