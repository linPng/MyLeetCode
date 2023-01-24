public class demo1828 {
    //统计一个圆中点的数目
    //枚举
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ret=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] e=queries[i];
            int x1=e[0],y1=e[1],r=e[2],t=0;
            for(int[] p:points){
                int x2=p[0]-x1,y2=p[1]-y1;
                if(r*r>=x2*x2+y2*y2){
                    t++;
                }
            }
            ret[i]=t;
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}