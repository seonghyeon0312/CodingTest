import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int w;
        public Edge(int s,int e,int w){ this.s=s; this.e=e; this.w=w; }
        public int compareTo(Edge e){
            if(this.w>e.w){
                return 1;
            }else{
                return -1;
            }
        }
    }

    static int n;
    static int m;

    static PriorityQueue<Edge> edges=new PriorityQueue<>();
    static int[] distance;
    static boolean minus=false;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        distance= new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i]=i;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            Edge edge=new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            edges.add(edge);
        }
        int total_weight=0;
        int cnt=0;
        while(cnt!=n-1 && !edges.isEmpty()){
            Edge now=edges.poll();
            int start=now.s;
            int end=now.e;
            int weight=now.w;
            if(find(start)!=find(end)){
                union(start,end);
                total_weight+=weight;
                cnt++;
            }else{
                continue;
            }
        }
        System.out.print(total_weight);
    }
    public static void union(int start, int end){
        if((distance[start]==start)&&(distance[end]==end)){
            distance[end]=distance[start];
        }else{
            int result1=find(start);
            int result2=find(end);
            distance[result2]=distance[result1];
        }
    }
    public static int find(int n){
        if(distance[n]!=n){
            distance[n]=find(distance[n]);
        }
        return distance[n];
    }
}
