import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static int v;
    static int e;
    static int k;
    static boolean visited[];
    static int shortest[];
    static ArrayList<Node> graph[];

    static class Node implements Comparable<Node> {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
        public int compareTo(Node e){
            if(this.w>e.w){
                return 1;
            } else{
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        v =Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        k=Integer.parseInt(st.nextToken());
        visited=new boolean[v+1]; // visited init

        //shortest init
        shortest=new int[v+1];
        for(int i=1;i<=v;i++){
            shortest[i]=Integer.MAX_VALUE;
        }

        //graph init
        graph=new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            graph[i]=new ArrayList<Node>();
        }

        for(int i=1;i<=e;i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }
        Dijk(k);
        for(int i=1;i<=v;i++){
            if(visited[i])
                System.out.println(shortest[i]);
            else
                System.out.println("INF");
        }

    }

    public static void Dijk(int k){
        PriorityQueue<Node> queue= new PriorityQueue<>();
        queue.add(new Node(k,0));
        shortest[k]=0;
        while(!queue.isEmpty()){
            Node now=queue.poll();
            int c_v=now.e;
            if(visited[c_v]) continue;
            visited[c_v]=true;
            for(int i=0;i<graph[c_v].size();i++){
                Node edge=graph[c_v].get(i);
                int u=edge.e;
                int w=edge.w;

                if(((shortest[c_v]+w)<(shortest[u]))){
                    shortest[u]=shortest[c_v]+w;
                    queue.add(new Node(u,shortest[u]));
                }
            }
        }
    }
}
