package contest.weeklycontest89;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class B {
    //853. 车队
    //经典优先队列
    public int carFleet(int target, int[] position, int[] speed) {
        int ret = 0;
        int n=position.length;
        double time[]= new double[n];//如果没有阻挡,抵达的时间
        PriorityQueue<int[]> dist = new PriorityQueue<int[]>((a, b) -> a[0] == b[0]?a[2]-b[2]:a[0]-b[0]);
        for(int i=0;i<n;i++){
            time[i]=(double)(target-position[i])/speed[i];
            dist.offer(new int[]{target-position[i],i,speed[i]});
        }
        double ti=0;
        while(dist.size()>0){
            int [] t=dist.poll();
            //System.out.println("t[0] = " + t[0]+"t[1] = " + t[1]+"t[2] = " + t[2]+"ti = " + ti);
            if(time[t[1]]>ti){
                ret++;
                ti=time[t[1]];
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        B b = new B();
        System.out.println("b.carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3}) = " + b.carFleet(12,new int[]{10,8,0,5,3},new int[]{2,4,1,1,3}));
    }
}
