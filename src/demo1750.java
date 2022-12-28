public class demo1750 {
    //删除字符串两端相同字符后的最短长度
    public static int minimumLength(String s) {
        while(s.length()>0){
            if(s.length()==1){
                return 1;
            }
            if(s.charAt(0)==s.charAt(s.length()-1)){
                int l=0,r=s.length()-1;
                char c=s.charAt(0);
                while(s.charAt(l+1)==c){l++;if(l==r){return 0;}}
                while(s.charAt(r-1)==c){r--;}
                s=s.substring(l+1,r);
            }else{
                break;
            }
        }
        return s.length();
    }
    //双指针
    public int minimumLength2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }
            while (left <= right && s.charAt(right) == c) {
                right--;
            }
        }
        return right - left + 1;
    }
    public static void main(String[] args) {

        System.out.println("args = " + minimumLength("cabaabac"));
    }

}