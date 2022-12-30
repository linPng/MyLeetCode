import java.util.ArrayDeque;
import java.util.Deque;

public class demo84 {
    //柱状图中最大的矩形

    //单调栈+哨兵
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length+ 2,max=0;
        int[] heights2 = new int[n];
        heights2[0]=-1;
        heights2[n-1]=-1;
        System.arraycopy(heights,0,heights2,1,heights.length);
        Deque<Integer> d=new ArrayDeque<>();
        d.add(0);
        for(int i=1;i<n;i++){
            while(heights2[i]<heights2[d.getLast()]){
                int S,h=heights2[d.pollLast()],l=i-d.getLast()-1;//pollLast 弹出最后一个元素
                S=h*l;
                if(S>max){
                    max=S;
                }
            }
            d.add(i);
        }
        return max;
    }
    //暴力 O(n*n)
    public static int largestRectangleArea2(int[] heights) {
        int n=heights.length,max=0;
        for(int i=0;i<n;i++){
            int h=heights[i],l=i,r=i,w;
            while(l-1>=0&&heights[l-1]>=h){l--;}
            while(r+1<n&&heights[r+1]>=h){r++;}
            w=r-l+1;
            if(h*w>max)max=h*w;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(" = " + largestRectangleArea(new int[]{2,1,2}));
        System.out.println(" = " + largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}