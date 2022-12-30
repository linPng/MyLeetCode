import java.util.ArrayDeque;
import java.util.Deque;

public class demo85 {
    //最大矩形

    //预处理+单调栈+哨兵
    public static int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if(0==n){
            return 0;
        }
        int m=matrix[0].length;
        if(0==m){
            return 0;
        }
        for(int j=0;j<n;j++){//标记右侧1的数量
            int t=0;
            for(int i=m-1;i>=0;i--){
                if(matrix[j][i]=='1'){
                    t++;
                }else{
                    t=0;
                }
                matrix[j][i]=(char)t;
            }
        }
        int max=0;
        for(int i=0;i<m;i++){//遍历每列 单调栈+哨兵
            int[] h=new int[n+2];
            h[0]=-1;h[n+1]=-1;
            for(int j=0;j<n;j++){
                h[j+1]=matrix[j][i];
            }
            Deque<Integer> d= new ArrayDeque<>();
            d.addLast(0);
            for(int k=1;k<n+2;k++){
                while(h[k]<h[d.getLast()]){
                    int H=h[d.pollLast()];
                    int L=k-d.getLast()-1;
                    int S=H*L;
                    if(S>max){
                        max=S;
                    }
                }
                d.addLast(k);
            }

        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(" = " + maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

}