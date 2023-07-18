import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class demo235 {
    //二叉搜索树的最近公共祖先


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
    public void dfs1(TreeNode root, TreeNode p){
        set.add(root);
        if(root.val==p.val){
            return;
        }else if(root.val>p.val){
            dfs1(root.left,p);
        }else{
            dfs1(root.right,p);
        }
    }
    public void dfs2(TreeNode root, TreeNode p){
        list.add(root);
        if(root.val==p.val){
            return;
        }else if(root.val>p.val){
            dfs2(root.left,p);
        }else{
            dfs2(root.right,p);
        }
    }
    public static void main(String[] args) {

    }
}