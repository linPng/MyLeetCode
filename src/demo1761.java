import java.util.*;

public class demo1761 {
    //1761. 一个图中连通三元组的最小度数
    public int minTrioDegree(int n, int[][] edges) {
        int ret=Integer.MAX_VALUE;
        //建图
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        int sz[] = new int[n+1];
        for (int i = 0; i <= n; ++i) {//初始化
            graph.add(new HashSet<Integer>());
        }
        for (int[] edge: edges) {//建图
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            sz[u]++;
            sz[v]++;
        }
        //求三元 1暴力枚举所有点判断是不是三元 2暴力枚举所有边是不是三元  好像枚举边会好一点
        //Set s=new HashSet();
        for(int[]e:edges){
            int a=e[0];
            int b=e[1];
            if(sz[a]<=1||sz[b]<=1){
                continue;
            }
            Set<Integer> s1=graph.get(a);
            Set<Integer> s2=graph.get(b);
            for(int c:s1){
                if(s2.contains(c)){
                    //int[] k=new int[]{a,b,c}; //排序了更慢
                    //Arrays.sort(k);
                    //String key=k[0]+"#"+k[1]+"#"+k[2];
                    //if(!s.contains(key)){
                        ret=Math.min(ret,sz[a]+sz[b]+sz[c]-6);
                        //s.add(key);
                    //}
                }
            }
        }

        //取最小
        return ret==Integer.MAX_VALUE?-1:ret;
    }
    public static void main(String[] args) {

    }
}
