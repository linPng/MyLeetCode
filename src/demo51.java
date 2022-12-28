import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class demo51 {
    //N皇后
    public static List<List<String>> solveNQueens(int n) {
        //int[][] N= new int[n][n];
        Deque<int[][]> D =new ArrayDeque<>();
        List<List<String>> r=new ArrayList<>();
        f(D,n,r);
        return r;
    }
    public static void f(Deque<int[][]> D,int n,List<List<String>> r){
        if(D.size()==n){//生成结果
            int[][] d=D.getLast();
            List<String> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuffer sb=new StringBuffer();
                for(int j=0;j<n;j++){
                    if(d[i][j]<=0){
                        sb.append(".");
                    }else{
                        sb.append("Q");
                    }
                }
                l.add(sb.toString());
            }
            r.add(l);
            return;
        }
        int x=D.size();
        for(int y=0;y<n;y++){
            int[][] d=new int[n][n];
            if (D.size()>0) {
                for(int q=0;q<n;q++){
                    d[q]=D.getLast()[q].clone();
                }
            }
            if(d[x][y]==0){
                //生成添加皇后后的图;
                for(int a=0;a<n;a++){
                    for(int b=0;b<n;b++){
                        if(x==a&&y==b){
                            d[a][b]=x+1;
                        }else if(x==a){
                            d[a][b]=-1;
                        }else if(y==b){
                            d[a][b]=-1;
                        }else if(a+b==x+y){
                            d[a][b]=-1;
                        }else if(a-b==x-y){
                            d[a][b]=-1;
                        }
                    }
                }
                D.addLast(d);
                f(D,n,r);
                D.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> r=solveNQueens(4);
        System.out.println("r = " + r);
    }

}