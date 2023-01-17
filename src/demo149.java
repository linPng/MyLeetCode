import java.util.HashMap;
import java.util.Map;

public class demo149 {
    //直线上最多的点数 困难 不会
    //暴力 n*n*n  哈希表 n*n
    public static int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2){
            return n;
        }
        int ret=0;
        for(int i=0;i<n;i++){
            //统计过i点的直线上点的数量 key是斜率，value是数量（除去i点）
            //优化 如果剩余的点少于目前的最大值就没必要计算了
            if(ret>n/2||ret>n-i){
                break;
            }
            Map<String,Integer> map = new HashMap<>();
            int max=0;
            int xi=points[i][0],yi=points[i][1];
            for(int j=i+1;j<n;j++){
                int xj=points[j][0],yj=points[j][1];
                int x=xj-xi,y=yj-yi;
                int g=gcd(x,y);//
                x=x/g;
                y=y/g;
                String key=x+"#"+y;//除掉公约数后的符号会一致
                map.put(key,map.getOrDefault(key,0)+1);
                max=Integer.max(max,map.getOrDefault(key,0)+1);
            }
            ret=Integer.max(ret,max);
        }
        return ret;
    }
    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
    public static void main(String[] args) {
        System.out.println(" = " + maxPoints(new int[][]{{1,2},{0,3},{2,1}}));
    }

}