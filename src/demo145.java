import java.util.ArrayList;
import java.util.List;

public class demo145 {
    //二叉树的前序遍历二叉树的后序遍历 简单
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret=new ArrayList<>();
        dfs(root,ret);
        return ret;
    }
    public static void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left!=null){
            dfs(root.left,list);
        }
        if(root.right!=null){
            dfs(root.right,list);
        }
        list.add(root.val);
    }

}