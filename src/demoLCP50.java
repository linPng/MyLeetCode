import java.lang.reflect.Array;
import java.util.Arrays;

public class demoLCP50 {
    //LCP 50. 宝石补给
    public int giveGem(int[] gem, int[][] operations) {
        for(int[] t:operations){
            int z = gem[t[0]]/2;
            gem[t[0]]-=z;
            gem[t[1]]+=z;
        }
        Arrays.sort(gem);
        return gem[gem.length-1]-gem[0];
    }
    public static void main(String[] args) {

    }
}
