public class demo125 {
    //
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        //码表ASCII 65:A 90Z  97:a 122:z   48:0   57:9
        char[] chars=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
                sb.append(c);
            }
        }
        s=sb.toString();
        chars=s.toCharArray();
        for(int i=0;i< chars.length/2;i++){
            if(chars[i]!=chars[chars.length-1-i]){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + isPalindrome("0P"));
        System.out.println(" = " + isPalindrome("A man, a plan, a canal: Panama"));
    }

}