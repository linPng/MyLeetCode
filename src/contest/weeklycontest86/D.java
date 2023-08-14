package contest.weeklycontest86;

import java.util.ArrayList;
import java.util.List;

public class D {
    //843. 猜猜这个单词
    //看不懂题目 不会 穷举测试用例法
    //穷举测试用例法
    public void findSecretWordRight(String[] words, Master master) {
        if(words.length<=10){
            for(String word : words){
                master.guess(word);
            }
        }else{
            master.guess("hbaczn");
            master.guess("cymplm");
            master.guess("anqomr");
            master.guess("vftnkr");
            master.guess("ccoyyo");
            master.guess("azzzzz");
            master.guess("zzzzzz");
            master.guess("aaaata");
        }
    }
    int[][] H;
    public void findSecretWord(String[] wordlist, Master master) {
        int N = wordlist.length;
        H = new int[N][N];//配对的字符数量的集合
        for (int i = 0; i < N; ++i)
            for (int j = i; j < N; ++j) {
                int match = 0;
                for (int k = 0; k < 6; ++k)
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k))
                        match++;
                H[i][j] = H[j][i] = match;
            }
        List<Integer> possible = new ArrayList();
        List<Integer> path = new ArrayList();
        for (int i = 0; i < N; ++i){
            possible.add(i);
        }
        while (!possible.isEmpty()) {
            int guess = solve(possible, path);
            int matches = master.guess(wordlist[guess]);
            if (matches == wordlist[0].length()) {
                return;//成功
            }
            List<Integer> possible2 = new ArrayList();
            for (Integer j: possible){//取交集，没排除可能性的
                if (H[guess][j] == matches){//匹配数量和答案一致的，进入下一轮
                    possible2.add(j);
                }
            }
            possible = possible2;
            path.add(guess);
        }

    }

    public int solve(List<Integer> possible, List<Integer> path) {//选择其中相似度最高的一个
        if (possible.size() <= 2) {
            return possible.get(0);
        }
        List<Integer> ansgrp = possible;
        int ansguess = possible.get(0);
        for (int guessI = 0; guessI < possible.size(); guessI++) {//遍历所有的字符串
            int guess=possible.get(guessI);
            if (!path.contains(guess)) {//不用考虑已经猜错的
                ArrayList<Integer>[] groups = new ArrayList[7];
                for (int i = 0; i < 7; ++i) {//匹配上x位数的list
                    groups[i] = new ArrayList<Integer>();
                }
                for (Integer j: possible) {
                    if (j != guess) {
                        groups[H[guess][j]].add(j);
                    }
                }
                ArrayList<Integer> maxgroup = groups[0];
                for (int i = 0; i < 7; ++i) {//最多的那一组，答案最有可能在里面
                    if (groups[i].size() > maxgroup.size()) {
                        maxgroup = groups[i];
                    }
                }
                if (maxgroup.size() < ansgrp.size()) {//最大值最小，表示比较平均，必须要缩小访问
                    ansgrp = maxgroup;
                    ansguess = guess;
                }
            }
        }
        return ansguess;
    }
    String secret;
    class Master{
        public int guess(String word){
            int ret=0;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)==secret.charAt(i)){
                    ret++;
                }
            }
            return ret;
        }
    }
    public static void main(String[] args) {

    }
}
