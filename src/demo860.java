public class demo860 {
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int[] b=new int[2];
        for(int i:bills){
            if(i==5){
                b[0]++;
            }else if(i==10){
                if(b[0]-->0){
                    b[1]++;
                }else{
                    return false;
                }
            }else{
                if(b[1]>0&&b[0]>0){
                    b[1]--;b[0]--;
                }else if(b[0]>=3){
                    b[0]=b[0]-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
