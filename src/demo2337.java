public class demo2337 {
    //2337. 移动片段得到字符串
    public boolean canChange(String start, String target) {
        int n=start.length();
        int i=0;
        int j=0;
        while(i<n&&j<n){
            while(i<n&&start.charAt(i)=='_'){
                i++;
            }
            while(j<n&&target.charAt(j)=='_'){
                j++;
            }
            if(i>=n||j>=n){
                break;
            }
            if(start.charAt(i)!=target.charAt(j)){
                return false;
            }
            if(start.charAt(i)=='L'&&i<j){
                return false;
            }
            if(start.charAt(i)=='R'&&i>j){
                return false;
            }
            i++;
            j++;
        }
        while(i<n){
            if(start.charAt(i)!='_'){
                return false;
            }
            i++;
        }
        while(j<n){
            if(target.charAt(j)!='_'){
                return false;
            }
            j++;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
