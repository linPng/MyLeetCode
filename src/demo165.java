public class demo165 {
    //比较版本号
    public static int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        for(int i=0;i<s1.length||i<s2.length;i++){
            int a,b;
            try {
                a=Integer.valueOf(s1[i]);
            } catch (Exception e) {
                a=0;
            }
            try {
                b=Integer.valueOf(s2[i]);
            } catch (Exception e) {
                b=0;
            }
            if(a>b){
                return 1;
            }else if(a<b){
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(" = " + compareVersion("0.1","1.1"));
    }
}
