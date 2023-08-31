import java.util.*;

public class demo1654 {
    //1654. 到家的最少跳跃次数
    //bfs
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int ret=0;
        int maxr=Arrays.stream(forbidden).max().getAsInt();
        maxr=Math.max(maxr,x);
        maxr+=2000+b+1;
        Deque<Integer[]> d= new LinkedList();//0:位置索引  1:表示上一步是前跳还是后跳
        Set<Integer> s=new HashSet<>();
        for(Integer i:forbidden){
            s.add(i);
        }
        if(x==0){
            return 0;
        }
        d.add(new Integer[]{x,0});
        s.add(x);
        while(d.size()>0){
            ret++;//每一步加1
            int n=d.size();
            while(n-->0){
                Integer[] t=d.pollFirst();
                int q=t[0]-a;
                int w=t[0]+b;
                if(t[1]==2){
                    w=-1;//不能两次后跳
                }
                if(q==0||w==0){
                    return ret;
                }
                if(q>0&&q<maxr&&!s.contains(q)){
                    d.offerLast(new Integer[]{q,1});
                    s.add(q);
                }
                if(w>0&&w<maxr&&!s.contains(w)){
                    d.offerLast(new Integer[]{w,2});
                    s.add(q);
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
