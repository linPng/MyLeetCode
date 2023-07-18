import java.util.Arrays;

public class demo275 {
    //H 指数 II
    public int hIndex(int[] citations) {
        int ret=0;
        for(int i=citations.length-1;i>=0;i--){
            int x=citations[i];
            int y=citations.length-i;
            if(x>=y){
                ret=y;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
