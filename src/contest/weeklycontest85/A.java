package contest.weeklycontest85;

public class A {
    //836. 矩形重叠
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] a,b;
        if(rec1[0]>rec2[0]){
         b=rec1;
         a=rec2;
        }else{
            a=rec1;
            b=rec2;
        }
        if(a[0]==a[2]||a[1]==a[3]||b[0]==b[2]||b[1]==b[3]){
            return false;
        }
        if(a[0]<=b[0]&&a[2]<=b[0]){
            return false;
        }
        if(a[0]>=b[2]&&a[2]>=b[2]){
            return false;
        }
        if(a[1]<=b[1]&&a[3]<=b[1]){
            return false;
        }
        if(a[1]>=b[3]&&a[3]>=b[3]){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
