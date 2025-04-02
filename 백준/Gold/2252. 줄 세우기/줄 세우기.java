import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Main{

    static int N,M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            indegree[end]++;
        }
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        sort();
    }

    static void sort(){
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for (Integer node : graph.get(now)) {
                if(indegree[node]>0){
                    indegree[node]--;
                    if(indegree[node]==0){
                        queue.add(node);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}