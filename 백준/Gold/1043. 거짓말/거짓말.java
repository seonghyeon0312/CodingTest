import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int[] people;
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int result=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        party=new ArrayList[m];
        people=new int[n+1];
        for(int i=1;i<=n;i++){
            people[i]=i;
        }

        int truth=sc.nextInt();
        trueP=new int[truth];
        for(int i=0;i<truth;i++){
            trueP[i]=sc.nextInt();
        }

        for(int i=0;i<m;i++){
            party[i]=new ArrayList<Integer>();
            int pSize=sc.nextInt();
            for(int j=0;j<pSize;j++){
                party[i].add(sc.nextInt());
            }
        }
        for(int i=0;i<m;i++){
            int frist=party[i].get(0);
            for(int j=1;j<party[i].size();j++){
                Union(frist,party[i].get(j));
            }
        }

        for(int i=0;i<m;i++){
            boolean isTruth=true;
            int current=party[i].get(0);
            for(int j=0;j<trueP.length;j++){
                if(_find(current)==_find(trueP[j])){
                    isTruth=false;
                    break;
                }
            }
            if(isTruth) result++;
        }
        System.out.println(result);
    }
    public static void Union(int i, int j){
        if((people[i]==i)&&(people[j]==j)){
            people[j]=i;
        }else{
            int result1=_find(i);
            int result2=_find(j);

            people[result2]=people[result1];
        }
    }
    public static int _find(int i){
        if(people[i]!=i){
            people[i]=_find(people[i]);
        }
        return people[i];
    }
}
