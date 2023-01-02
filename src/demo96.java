import java.util.ArrayList;
import java.util.List;

public class demo96 {
    //不同的二叉搜索树
    public static int numTrees(int n) {
        return f(1,n);
    }
    //暴力解
    public static int f(int l,int r){
        int ret=0;
        if(l>r){return 1;}
        if(l==r){return 1;}
        for(int i=l;i<=r;i++){
            int left=f(l,i-1);
            int right=f(i+1,r);
            ret+=left*right;
        }
        return ret;
    }
    //卡塔兰数 Cn+1=Cn*(2(2n+1)/(n+2))  （从第0项开始）：1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012,
    //Cn+1=C0*Cn+C1*Cn-1+...+Cn*C0;
    public static int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
    //动态规划计算卡塔兰数
    public static int numTrees3(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    public static void main(String[] args) {
        System.out.println(" = " + numTrees(3));
        System.out.println(" = " + numTrees(1));
        System.out.println(" = " + numTrees2(3));
        System.out.println(" = " + numTrees2(1));
    }
 public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}