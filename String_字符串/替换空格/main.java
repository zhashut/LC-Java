package String_字符串.替换空格;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/20
 * Time: 20:13
 * Description: No Description
 */
public class main {
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] ch = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                builder.append("%20");
                continue;
            }
            builder.append(String.valueOf(ch[i]));
        }

        return builder.toString();
    }

    // 方式二：双指针法
    public String replaceSpace2(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        // 扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        // 有空格情况 定义两个指针
        // 左指针：指向原始字符串最后一个位置
        int left = s.length() - 1;
        s += str.toString();
        // 右指针：指向扩展字符串的最后一个位置
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
