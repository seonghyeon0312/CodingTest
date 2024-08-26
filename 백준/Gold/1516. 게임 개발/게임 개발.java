import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {

    static int n;
    static ArrayList<Integer>[] arrayList;
    static int[] result;
    static int[] count;
    static int[] time;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        arrayList=new ArrayList[n+1];
        result=new int[n+1];
        time=new int[n+1];
        count=new int[n+1];
        for(int i=1;i<=n;i++){
            arrayList[i]=new ArrayList<>();
        }
        //건물 별 짓는 시간 및 선행 건물 저장
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                final int e = Integer.parseInt(st.nextToken());
                if(e==-1){
                    break;
                }
                arrayList[e].add(i);
                count[i]++;
            }
        }

        for(int i=1;i<=n;i++){
            if(count[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0;i<arrayList[now].size();i++){
                final Integer number = arrayList[now].get(i);
                count[number]--;
                if(count[number]==0){
                    queue.add(number);
                }
                result[number]=Math.max(result[number],result[now]+time[now]);
            }
        }

        for(int i=1;i<=n;i++){
            result[i]+=time[i];
            System.out.println(result[i]);
        }


    }
}