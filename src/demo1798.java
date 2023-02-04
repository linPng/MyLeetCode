import java.util.Arrays;

public class demo1798 {
    //你能构造出连续值的最大数目
    public int getMaximumConsecutive(int[] coins) {
        int ret =1;
        Arrays.sort(coins);
        for(int i:coins){
            if(ret>=i){
                ret+=i;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}