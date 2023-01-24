public class demo14 {
    //最长公共前缀 简单
    public String longestCommonPrefix(String[] strs) {
        int i=1;
        String c="";
        while(true){
            if(strs[0].length()<i){
                if(c.length()>0){
                    return c.substring(0,c.length());
                }else{
                    return "";
                }
            }
            c=strs[0].substring(0,i);
            for(int j=0;j<strs.length;j++){
                if(c.length()>strs[j].length()){
                    if(c.length()>0){
                        return c.substring(0,c.length()-1);
                    }else{
                        return "";
                    }
                }
                if(strs[j].startsWith(c)){

                }else{
                    if(c.length()>0){
                        return c.substring(0,c.length()-1);
                    }else{
                        return "";
                    }
                }
            }
            i++;

        }
        //return c;
    }
    public static void main(String[] args) {

    }
}