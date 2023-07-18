import java.util.Arrays;

public class demo274 {
    //H 指数
    public int hIndex(int[] citations) {
        int ret=0;
        Arrays.sort(citations);
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
