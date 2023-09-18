import java.util.Map;
import java.util.HashMap;

public class demo337 {
    //337. 打家劫舍 III
    Map<TreeNode,Integer> map=new HashMap();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        if(root.left==null&&root.right==null){
            map.put(root,root.val);
            return root.val;
        }
        int ret=rob(root.left)+rob(root.right);
        int ret2=root.val;
        if(root.left!=null){
            ret2+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            ret2+=rob(root.right.left)+rob(root.right.right);
        }
        ret=Math.max(ret,ret2);
        map.put(root,ret);
        return ret;
    }
    public static void main(String[] args) {

    }
}
