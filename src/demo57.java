import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class demo57 {
    //插入区间

    //暴力解
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> l=new ArrayList<>();
        boolean f=true;
        for(int i=0;i<intervals.length;i++){
            int[] e=intervals[i];
            //for(int[] e:l){
                int a=newInterval[0],b=newInterval[1],c=e[0],d=e[1];
                if(d<a){
                    l.add(e);
                }else if(b>=c&&a<=d){
                    newInterval[0]=Math.min(a,c);
                    newInterval[1]=Math.max(b,d);
                }else{
                    if (f) {
                        l.add(newInterval);
                        f=false;
                    }
                    l.add(e);
                }
            //}
        }
        if (f) {
            l.add(newInterval);
            f=false;
        }
        //list转数组
        int[][] r=new int[l.size()][];
        int i=0;
        for(int[] e:l){
            r[i]=e;
            i++;
        }
        return r;
    }
    public static void main(String[] args) {
        int[][] n=new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        System.out.println(" = " + insert(n,new int[]{4,8}));
    }

}