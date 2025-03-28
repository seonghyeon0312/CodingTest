import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bufferedReader.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken());
        visited= new boolean[n+1]; // 방문배열 초기화
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bufferedReader.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1;i<=n;i++){
            //더 작은 노드부터 방문하기 위한 정렬
            Collections.sort(graph[i]);
        }
        DFS(v);
        System.out.println();
        visited=new boolean[n+1];
        BFS(v);
    }

    private static void DFS(int start){
        System.out.print(start+" ");
        visited[start]=true;
        for(int i : graph[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    private static void BFS(int start){
        Queue<Integer> que=new LinkedList<Integer>();
        que.add(start);
        visited[start]=true;
        while (!que.isEmpty()){
            int find=que.poll();
            System.out.print(find+" ");
            for(int i : graph[find]){
                if(!visited[i]){
                    visited[i]=true;
                    que.add(i);
                }
            }
        }
        System.out.println();
    }
}
