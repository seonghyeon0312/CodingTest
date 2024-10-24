import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    private static List<Human> humanList = new ArrayList<>();
    private static List<Integer> sizeRank = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Integer total = Integer.parseInt(st.nextToken());

        for(int i=0;i<total;i++){
            st=new StringTokenizer(bf.readLine());

            Integer height=Integer.parseInt(st.nextToken());
            Integer weight=Integer.parseInt(st.nextToken());
            Human human = new Human(height, weight);
            humanList.add(human);
            sizeRank.add(total);
        }

        for (Human human : humanList) {
            Integer result = human.compareTo();
            final int i = humanList.indexOf(human);
            Integer nowRank = sizeRank.get(i);
            sizeRank.set(i,nowRank+result);
        }

        StringJoiner sj=new StringJoiner(" ");

        for(Integer rank : sizeRank){
            sj.add(rank.toString());
        }
        System.out.println(sj);
    }

    static class Human{
        private final Integer height;
        private final Integer weight;

        public Human(Integer h, Integer w){
            height=h;
            weight=w;
        }

        public Integer compareTo(){
            Integer sum = 0;
            for (Human human : humanList) {
                if(human!=this){
                    if(this.height<human.height && this.weight<human.weight){
                        sum+=0;
                    }else{
                        sum-=1;
                    }
                }
            }
            return sum;
        }
    }
}
