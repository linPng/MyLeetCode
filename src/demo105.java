public class demo105 {
    //从前序与中序遍历序列构造二叉树
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        if(n==0){
            return null;
        }
        int rootval=preorder[0];
        if(n==1){
            return new TreeNode(rootval);
        }
        int ro_i=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootval){
                ro_i=i;
                break;
            }
        }
        int[] lp=new int[ro_i],li=new int[ro_i],rp=new int[n-ro_i-1],ri=new int[n-ro_i-1];
        for(int i=0;i<ro_i;i++){
            lp[i]=preorder[1+i];
            li[i]=inorder[i];
        }
        for(int i=n-1;i>ro_i;i--){
            rp[i-ro_i-1]=preorder[i];
            ri[i-ro_i-1]=inorder[i];
        }
        return new TreeNode(rootval, buildTree(lp,li), buildTree(rp,ri));
    }
    public static void main(String[] args) {
    }

}