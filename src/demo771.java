import java.util.HashSet;
import java.util.Set;

public class demo771 {
    //宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        int ret=0;
        Set set=new HashSet();
        for(char i:jewels.toCharArray()){
            set.add(i);
        }
        for(char i:stones.toCharArray()){
            if(set.contains(i)){
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}