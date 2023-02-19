import java.util.Arrays;

public class demo2335 {
    //装满杯子需要的最短总时长
    //贪心
    public int fillCups(int[] amount) {
        if (amount[0] >= (amount[1] + amount[2])) return amount[0];
        if (amount[1] >= (amount[0] + amount[2])) return amount[1];
        if (amount[2] >= (amount[1] + amount[0])) return amount[2];
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
    //太复杂
    public int fillCups2(int[] amount) {
        int ret=0;
        Arrays.sort(amount);
        int t=(amount[1]+amount[0])-amount[2];
        if(t<=0){
            ret=amount[2];
        }else{
            ret=amount[2]+t/2+t%2;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}