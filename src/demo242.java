import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo242 {
    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        if(String.valueOf(cs).equals(String.valueOf(ct))){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}