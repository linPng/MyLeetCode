import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class demo2578 {
    //2578. 最小和分割
    public int splitNum(int num) {
        Deque<Integer> d=new LinkedList();
        while(num>0){
            d.addLast(num%10);
            num=num/10;
        }
        if(d.size()%2==1){
            d.addFirst(0);
        }
        Collections.sort((List) d);
        int n1=0,n2=0;
        while(!d.isEmpty()){
            n1=n1*10+d.pollFirst();
            n2=n2*10+d.pollFirst();
        }
        return n1+n2;
    }
    public static void main(String[] args) {

    }
}
