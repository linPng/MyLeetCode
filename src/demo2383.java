public class demo2383 {
    //赢得比赛需要的最少训练时长
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ret=0,ret2=0,m=0,m2=0;
        for(int i=0;i<energy.length;i++){
            m+=energy[i];
            if(initialEnergy+ret<=m){
                ret=m+1-initialEnergy;
            }
            if(initialExperience+ret2+m2<=experience[i]){
                ret2=experience[i]+1-initialExperience+m2;
            }
            m2+=experience[i];
        }
        return ret+ret2;
    }

    public static void main(String[] args) {

    }
}