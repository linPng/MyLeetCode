import java.util.*;

public class demo2512 {
    //2512. 奖励最顶尖的 K 名学生
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> ret = new LinkedList<>();
        Set<String> ps=new HashSet<>();
        Set<String> ns=new HashSet<>();
        for(String s:positive_feedback){
            ps.add(s);
        }
        for(String s:negative_feedback){
            ns.add(s);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[0]==a[0]?a[1]-b[1]:b[0] - a[0]);
        for(int i=0;i<student_id.length;i++){
            int score=0;
            String[] words=report[i].split(" ");
            for(String s:words){
                if(ps.contains(s)){
                    score+=3;
                }else if(ns.contains(s)){
                    score-=1;
                }
            }
            pq.add(new int[]{score,student_id[i]});
        }
        for(int i=0;i<k;i++){
            ret.add(pq.poll()[1]);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
