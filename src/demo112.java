import java.util.ArrayList;
import java.util.List;

public class demo112 {
    //路径总和
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return f(root,targetSum,0);
    }
    public static boolean f(TreeNode root, int targetSum,int sum){
        if(root==null){
            return false;
        }
        if(targetSum<root.val+sum){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(targetSum==root.val+sum){
                return true;
            }else{
                return false;
            }
        }
        return f(root.left,targetSum,sum+root.val)||f(root.right,targetSum,sum+root.val);
    }
    public static void main(String[] args) {


    }

}