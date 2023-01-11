import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class demo6288 {
    //找到数据流中的连续整数
    class DataStream {
        Deque<Integer> d =new ArrayDeque<>();
        int V =0;
        int K=0;
        int E=0;
        public DataStream(int value, int k) {
            V=value;
            K=k;
        }

        public boolean consec(int num) {
            if(num==V){
                E++;
            }
            d.add(num);
            if(d.size()<K){
                return false;
            }
            if(d.size()>K){
                if(d.pollFirst()==V){
                    E--;
                }
            }
            if(E!=K){
                return false;
            }
            return true;
        }
    }
    /*public static void main(String[] args) {
        System.out.println(" = " + getResult());
    }*/

}