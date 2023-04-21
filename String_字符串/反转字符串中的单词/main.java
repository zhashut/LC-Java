package String_字符串.反转字符串中的单词;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/21
 * Time: 22:01
 * Description: No Description
 */
public class main {

    public String reverseWords(String s) {
        // 去除首尾以及中间空格
        StringBuilder sb = removeSpace(s);
        // 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 反转各个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }

        return sb;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end-1);
            start = end + 1;
            end = start + 1;
        }
    }
    /**************************解法二：创建新字符数组填充。时间复杂度O(n)************************************/
    public String reverseWords2(String s) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length+1];//下面循环添加"单词 "，最终末尾的空格不会返回
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length-1;
        while(i>=0){
            while(i>=0 && initialArr[i] == ' '){i--;}  //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while(i>=0 && initialArr[i] != ' '){i--;}
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i+1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if(j == right){
                    newArr[newArrPos++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newArrPos == 0){
            return "";
        }else{
            return new String(newArr,0,newArrPos-1);
        }
    }
}
