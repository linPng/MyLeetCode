public class demo1813 {
    //句子相似性 III
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1=sentence1.split(" ");
        String[] s2=sentence2.split(" ");
        if(s2.length>s1.length){
            s1=s2;
            s2=sentence1.split(" ");
        }
        boolean b=true;
        for(int i=0;i<s2.length;i++){
            if(b){
                if(!s1[i].equals(s2[i])){
                    b=false;
                    i--;
                }
            }else{
                if(!s1[s1.length-s2.length+i].equals(s2[i])){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + areSentencesSimilar("My name is Haley",  "My Haley"));
    }

}