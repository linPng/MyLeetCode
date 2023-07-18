import java.util.ArrayList;
import java.util.List;

public class demo257 {
    //二叉树的所有路径
    List<String> ret=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root.left==null&&root.right==null){
            ret.add(String.valueOf(root.val));
            return ret;
        }
        if(null!=root.left){
            dfs(root.left,String.valueOf(root.val));
        }
        if(null!=root.right){
            dfs(root.right,String.valueOf(root.val));
        }
        return ret;
    }
    public void dfs(TreeNode root,String s){
        if(root.left==null&&root.right==null){
            ret.add(s+"->"+String.valueOf(root.val));
            return;
        }
        if(null!=root.left){
            dfs(root.left,s+"->"+String.valueOf(root.val));
        }
        if(null!=root.right){
            dfs(root.right,s+"->"+String.valueOf(root.val));
        }
    }
    public static void main(String[] args) {

    }
}