import java.util.ArrayList;
import java.util.List;

public class demo1145 {
    //二叉树着色游戏
    static TreeNode rootx;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int t=0,l=0,r=0;
        t=inorderTraversal(root,x);
        l=inorderTraversal(rootx.left,x);
        r=inorderTraversal(rootx.right,x);
        int max=Math.max(t,Math.max(l,r));
        int min=t+l+r+1-max;
        if(max>min){
            return true;
        }else{
            return false;
        }
    }
    //计数器
    public static int inorderTraversal(TreeNode root,int x) {
        if(root==null){
            return 0;
        }
        if(root.val==x){
            rootx=root;
            return 0;
        }
        int r=inorderTraversal(root.left,x);
        r++;
        r+=inorderTraversal(root.right,x);
        return r;
    }
    public static void main(String[] args) {

    }
}
