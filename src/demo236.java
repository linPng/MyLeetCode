import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class demo236 {
    //二叉树的最近公共祖先


    Set<TreeNode> set=new HashSet<>();
    List<TreeNode> list=new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret=root;
        dfs1(root,p);
        dfs2(root,q);
        for(int i=list.size()-1;i>=0;i--){
            if(set.contains(list.get(i))){
                return list.get(i);
            }
        }
        return ret;
    }
    public boolean dfs1(TreeNode root, TreeNode p){
        if(root==null){
            return false;
        }
        set.add(root);
        if(root.val==p.val){
            return true;
        }
        if(dfs1(root.left,p)){
            return true;
        }else{
            set.remove(root.left);
        }
        if(dfs1(root.right,p)){
            return true;
        }else{
            set.remove(root.right);
        }
        return false;
    }
    public boolean dfs2(TreeNode root, TreeNode p){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root.val==p.val){
            return true;
        }
        if(dfs2(root.left,p)){
            return true;
        }else{
            list.remove(root.left);
        }
        if(dfs2(root.right,p)){
            return true;
        }else{
            list.remove(root.right);
        }
        return false;
    }
    public static void main(String[] args) {

    }
}