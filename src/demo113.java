import java.util.ArrayList;
import java.util.List;

public class demo113 {
    //路径总和 II
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        List<Integer> list=new ArrayList<>();
        f(root,targetSum,0,ret,list);
        return ret;
    }
    public static void f(TreeNode root, int targetSum,int sum,List<List<Integer>> ret,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(targetSum==root.val+sum){
                list.add(root.val);
                ret.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        f(root.left,targetSum,sum+root.val,ret,list);
        f(root.right,targetSum,sum+root.val,ret,list);
        list.remove(list.size()-1);
        return ;
    }
    public static void main(String[] args) {


    }

}