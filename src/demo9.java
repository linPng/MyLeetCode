public class demo9 {
    //回文数
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int t=x;
        int p=0;
        while (t!=0){
            p=p*10+t%10;
            t=t/10;
        }
        if(p!=x){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
