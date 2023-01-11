public class demo6287 {
    //根据规则将箱子分类
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky=false,isHeavy=false;
        long v=(long)length*width*height;
        if(length>=10000||width>=10000||height>=10000||v>=1000000000){
            isBulky=true;
        }
        if(mass>=100){
            isHeavy=true;
        }
        if(isBulky&&isHeavy){
            return "Both";
        }
        if(isBulky){
            return "Bulky";
        }
        if(isHeavy){
            return "Heavy";
        }
        return "Neither";
    }
    public static void main(String[] args) {
        /*2909
3968
3272
727*/
        System.out.println(" = " + categorizeBox(2909,3968,3272,727));
    }

}