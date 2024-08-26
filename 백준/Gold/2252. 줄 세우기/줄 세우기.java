import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.util.Arrays.*;

public class Main {

    static int n,m;
    static ArrayList<Integer>[] arrayList;
    static int[] count;
    static Queue<Integer> queue= new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arrayList=new ArrayList[n+1];
        count= new int[n+1];
        StringBuilder result= new StringBuilder();

        for(int i=1;i<=n;i++){
            arrayList[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arrayList[a].add(b);
            count[b]++;
        }

        for(int i=1;i<=n;i++){
            if(count[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i=0;i<arrayList[now].size();i++){
                int num = arrayList[now].get(i);
                count[num]--;
                if(count[num]==0){
                    queue.add(num);
                }
            }

            String temp=String.valueOf(now);
            result.append(temp).append(" ");
        }

        System.out.println(result);
    }
}