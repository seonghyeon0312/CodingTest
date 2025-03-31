import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    static int[] visited;
    static int n,m,k,x;
    static ArrayList<Integer>[] graph;
    static List<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        graph=new ArrayList[n+1];
        result=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        visited=new int[n+1];
        for(int i=0;i<=n;i++){
            visited[i]=-1;
        }
        BFS(x);
        for(int i=0;i<=n;i++){
            if(visited[i]==k){
                result.add(i);
            }
        }
        if(result.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(result);
            for(int node:result){
                System.out.println(node);
            }
        }
    }
    private static void BFS(int start){
        Queue<Integer> node=new LinkedList<>();
        node.add(start);
        visited[start]++;
        while(!node.isEmpty()){
            int now=node.poll();
            for(int now_node:graph[now]){
                if(visited[now_node]==-1){
                    visited[now_node]=visited[now]+1;
                    node.add(now_node);
                }
            }
        }
    }
}
