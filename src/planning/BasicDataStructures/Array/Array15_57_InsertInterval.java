package planning.BasicDataStructures.Array;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Array15_57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> li = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        int n= intervals.length;
        for(int i=0;i<n;i++){
            int[] t=intervals[i];
            if(t[1]<newInterval[0]||t[0]>newInterval[1]){
                li.offer(t);
                //System.out.println("t[0] = " + t[0]+"t[1] = " + t[1]);
            }else{
                newInterval[0]=Math.min(newInterval[0],t[0]);
                newInterval[1]=Math.max(newInterval[1],t[1]);
            }
        }
        li.offer(newInterval);
        //System.out.println("newInterval[0] = " + newInterval[0]+"newInterval[1] = " + newInterval[1]);
        //System.out.println("li.size() = " + li.size());
        int rn=li.size();
        int[][] ret=new int[rn][];
        for(int i=0;i<rn;i++){
            ret[i]=li.poll();
            //System.out.println("ret[i] = " + ret[i]);
        }
        return ret;
    }
}
