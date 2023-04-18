package hash_table_哈希表.赎金信;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/18
 * Time: 22:36
 * Description: https://leetcode.cn/problems/ransom-note/
 */
public class main {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        canConstruct(ransomNote, magazine);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int v = ransomNote.charAt(i) - 'a';
            res[v]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            int v = magazine.charAt(i) - 'a';
            res[v]--;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
