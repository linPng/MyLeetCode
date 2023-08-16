import java.util.*;

public class demo2682 {
    //2682. 找出转圈游戏输家
    public int[] circularGameLosers(int n, int k) {
        Set set = new HashSet();
        int t=1;
        int c=1;
        set.add(1);
        while(true){
            int i=t+c*k;
            if(i>n){
                i=i%n;
                if(i==0){
                    i=n;
                }
            }
            if(set.contains(i)){
                break;
            }else{
                set.add(i);
            }
            t=i;
            c++;
        }
        List<Integer> list = new ArrayList();
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {

    }
}
