public class demo67 {
    //二进制求和
    public String addBinary(String a, String b) {
        if(b.length()>a.length()){
            String t=a;
            a=b;
            b=t;
        }
        int add=0;
        String r="";
        for(int i=0;i<a.length();i++){
            int x=a.charAt(a.length()-1-i)-'0';
            int y=b.length()-1-i>=0?b.charAt(b.length()-1-i)-'0':0;
            int sum=x+y+add;
            add=sum/2;
            r=sum%2+r;
        }
        if(add>0){
            r=add+r;
        }
        return r;
    }
    public static void main(String[] args) {

    }
}