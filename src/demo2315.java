public class demo2315 {
    //统计星号
    public int countAsterisks(String s) {
        int ret=0;
        boolean f=true;
        for(char c:s.toCharArray()){
            if(f&&c=='*'){
                ret++;
            }
            if(c=='|'){
                f=!f;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}