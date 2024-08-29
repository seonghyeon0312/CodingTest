import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int m;
    static ArrayList<Edge> graph[];
    static boolean visited[];
    static int distance[];

    static class Edge implements Comparable<Edge>{
        int v;
        int w;
        public Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
        public int compareTo(Edge e){
            if(this.w>e.w){
                return 1;
            }else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());

        visited=new boolean[n+1];
        distance=new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }

        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v,w));
        }
        st=new StringTokenizer(bf.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        Dijk(start);
        System.out.print(distance[end]);
    }
    public static void Dijk(int s){
        PriorityQueue<Edge> queue=new PriorityQueue<>();
        queue.add(new Edge(s,0));
        distance[s]=0;
        while(!queue.isEmpty()){
            Edge now=queue.poll();
            int v=now.v;
            if(visited[v]) continue;
            visited[v]=true;

            for(int i=0;i<graph[v].size();i++){
                Edge edge=graph[v].get(i);
                int u=edge.v;
                int w=edge.w;

                if((distance[v]+w)<distance[u]){
                    distance[u]=distance[v]+w;
                    queue.add(new Edge(u, distance[u]));
                }
            }
        }
    }
}