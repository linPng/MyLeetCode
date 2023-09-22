import java.util.Arrays;

public class demoLCP06 {
    //LCP 06. 拿硬币
    public int minCount(int[] coins) {
        int ret=0;
        for(int i:coins){
            ret+=i/2;
            if(i%2==1){
                ret+=1;
            }
            System.out.println("ret = " + ret);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
