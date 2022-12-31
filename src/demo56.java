import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class demo56 {
    //合并区间

    //暴力解
    public static int[][] merge(int[][] intervals) {
        List<int[]> l=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            List<int[]> t=new ArrayList<>();
            for(int[] e:l){
                int a=intervals[i][0],b=intervals[i][1],c=e[0],d=e[1];
                if(b>=c&&a<=d){
                    intervals[i][0]=Math.min(a,c);
                    intervals[i][1]=Math.max(b,d);
                }else{
                    t.add(e);
                }
            }
            t.add(intervals[i]);
            l=new ArrayList<>(t);
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

    //排序+双指针
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] n=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(" = " + merge(n));
    }

}