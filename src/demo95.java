import java.util.ArrayList;
import java.util.List;

public class demo95 {
    //不同的二叉搜索树 II
    public static List<TreeNode> generateTrees(int n) {
        return f(1,n);
    }
    public static List<TreeNode> f(int l,int r){
        List<TreeNode> ret=new ArrayList<>();
        if(l>r){ret.add(null);return ret;}
        if(l==r){ret.add(new TreeNode(l));return ret;}
        for(int i=l;i<=r;i++){
            List<TreeNode> left=f(l,i-1);
            List<TreeNode> right=f(i+1,r);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    ret.add(new TreeNode(i,left.get(j),right.get(k)));
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + generateTrees(3));
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