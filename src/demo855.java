import java.util.Set;
import java.util.TreeSet;

public class demo855 {
    //考场就座
    class ExamRoom {
        int N;
        TreeSet<Integer> er;
        public ExamRoom(int n) {
            N=n;
            er=new TreeSet<>();
        }

        public int seat() {
            int seatNum=0;
            if(er.size()==0){

            }else if(er.size()>=N){
                return -1;
            }else{
                Integer d=null;
                int max=0;
                for(int i:er){
                    if(d!=null){
                        int s=(i-d)/2;
                        if(s>max){
                            max=s;
                            seatNum=d+s;
                        }
                    }else{
                        seatNum=0;
                        max=Math.max(i,max);
                    }
                    d=i;
                }
                if(N-1-er.last()>max){
                    seatNum=N-1;
                }
            }

            er.add(seatNum);
            return seatNum;
        }

        public void leave(int p) {
            er.remove(p);
        }
    }
    public static void main(String[] args) {
        demo855 d=new demo855();
        ExamRoom e=d.new ExamRoom(4);
        System.out.println(" = " + e.seat());
        System.out.println(" = " + e.seat());
        System.out.println(" = " + e.seat());
        System.out.println(" = " + e.seat());
        e.leave(1);
        e.leave(3);
        System.out.println(" = " + e.seat());
    }

}
