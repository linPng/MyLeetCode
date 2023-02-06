import java.util.HashSet;
import java.util.Set;

public class demo202 {
    //快乐数
    //模拟
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            String s=String.valueOf(n);
            int t=0;
            for(char c:s.toCharArray()){
                int i=Integer.valueOf(c-'0');
                t+=i*i;
            }
            if(t==1){
                return true;
            }
            if(set.contains(t)){
                return false;
            }
            set.add(t);
            n=t;
        }
    }
    public static void main(String[] args) {
        System.out.println("isHappy(19) = " + isHappy(19));
    }
}
