import java.util.ArrayList;
import java.util.List;

public class demo258 {
    //各位相加
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        String s=String.valueOf(num);
        num=0;
        for(char c:s.toCharArray()){
            num+=c-'0';
        }
        return addDigits(num);
    }
    public static void main(String[] args) {

    }
}