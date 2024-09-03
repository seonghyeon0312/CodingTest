import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Edge> pQueue=new PriorityQueue<Edge>();
    static int[] node;
    static int n,m;

    static long result=0;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        node=new int[n+1];
        for(int i=1;i<=n;i++){
            node[i]=i;
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            Edge edge = new Edge(s,e,value);
            pQueue.add(edge);
        }

        for(int i=0;i<m;i++){
            Edge poll = pQueue.poll();
            boolean same = find(poll.s, poll.e);

            if(same){
                union(poll.s,poll.e);
                result+=poll.value;
            }
        }
        System.out.println(result);
    }
    private static void union(int s,int e){
        if(node[e]!=e){
            union(s,node[e]);
        }else{
            node[e]=s;
        }
    }

    private static boolean find(int s, int e){
        if(node[s]!=s){
            unionFind(s);
        }
        if(node[e]!=e){
            unionFind(e);
        }

        if(node[s]!=node[e]){
            return true;
        }else return false;
    }

    private static int unionFind(int s){
        if(node[s]==s){
            return s;
        }else{
            int result =unionFind(node[s]);
            node[s]=result;
            return result;
        }
    }
    private static class Edge implements Comparable<Edge>{
        private int s;
        private int e;
        private long value;

        public Edge(int s, int e, long value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.value>o.value){
                return 1;
            }else return -1;
        }
    }
}