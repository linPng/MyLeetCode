import java.util.HashSet;
import java.util.Set;

public class demo874 {
    //模拟行走机器人
    public int robotSim(int[] commands, int[][] obstacles) {
        int ret=0;
        Set set=new HashSet();
        int x=0,y=0,d=90;
        for(int[] o:obstacles){
            set.add(o[0]+"#"+o[1]);
        }
        for(int i:commands){
            if(i==-2){
                d+=90;
                d=d%360;
            }else if(i==-1){
                d-=90;
                if(d<0){
                    d+=360;
                }
                d=d%360;
            }else{
                int t=i;
                int x2=0,y2=0;
                if(d==0){
                    x2=1;
                }else if(d==90){
                    y2=1;
                }else if(d==180){
                    x2=-1;
                }else if(d==270){
                    y2=-1;
                }
                while(t-->0){
                    if(!set.contains((x+x2)+"#"+(y+y2))){
                        x+=x2;
                        y+=y2;
                    }
                }
                ret=Math.max(ret,x*x+y*y);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
