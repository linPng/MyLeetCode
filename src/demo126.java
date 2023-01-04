import java.util.*;

public class demo126 {
    //单词接龙 II 困难经典 层序遍历+逆回溯  暴力解 超出时间限制 需要通过层序遍历确认最短枝干;
    static Map<String, Set<String>> keymap=new HashMap<>();
    static Map<String, Integer> distmap=new HashMap<>();
    static List<Set<String>> distsetlist=new ArrayList<>();
    static Deque<String> path=new ArrayDeque<>();
    static List<List<String>> ret=new ArrayList<>();
    static int N=0;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        N=wordList.size();
        wordList.add(beginWord);
        for(String s:wordList){
            for(String t:wordList){
                if(!s.equals(t)&&isNear(s,t)){
                    Set<String> se=keymap.getOrDefault(s,new HashSet<>());
                    se.add(t);
                    keymap.put(s,se);
                }
            }
        }
        wordList.remove(beginWord);
        //求深度
        Deque<String> deep=new ArrayDeque();
        int dis=0;
        deep.add(beginWord);
        boolean isend=false;
        while(!deep.isEmpty()){
            dis++;
            int dsize=deep.size();
            for(int q=0;q<dsize;q++){
                String b =deep.pollFirst();
                for(String s:keymap.getOrDefault(b,new HashSet<>())){
                    if(s.equals(endWord)){
                        isend=true;
                    }
                    if(!distmap.containsKey(s)){
                        distmap.put(s,dis);
                        deep.addLast(s);
                    }
                }
            }
            distsetlist.add(new HashSet<>(deep));
            if(isend){break;}
        }
        if(!isend){
            return ret;
        }
        path.addFirst(endWord);
        if(distsetlist.size()-1==0){
            path.addFirst(beginWord);
            ret.add(new ArrayList<>(path));
            return ret;
        }
        dfs(beginWord,endWord,distsetlist.size()-1);
        //倒序删除list
        /*for(int i=ret.size()-1;i>=0;i--){
            if (ret.get(i).size()>N+1){
                ret.remove(i);
            }
        }*/
        return ret;
    }
    public static void dfs(String beginWord, String endWord, int layer){
        layer--;
        Set<String> dic=distsetlist.get(layer);
        for(String s:dic){
            if(!keymap.getOrDefault(endWord,new HashSet<>()).contains(s)){
                //dic.remove(s);
            }else{
                if(layer==0){
                    path.addFirst(s);
                    path.addFirst(beginWord);
                    ret.add(new ArrayList<>(path));
                    path.remove(beginWord);
                    path.remove(s);
                }else {
                    path.addFirst(s);
                    dfs(beginWord, s, layer);
                    path.remove(s);
                }
            }
        }
    }
    //仅有单个字母不同
    public static boolean isNear(String s1,String s2){
        int c=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                c++;
            }
        }
        if(c!=1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<String> wordList= new ArrayList<String>(Arrays.asList(new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"}));
        System.out.println(" = " + findLadders("cet","ism",wordList));
    }
}