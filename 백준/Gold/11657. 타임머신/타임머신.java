import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int s;
        int e;
        int w;
        public Edge(int s,int e,int w){ this.s=s; this.e=e; this.w=w; }
    }

    static int n;
    static int m;

    static Edge edges[];
    static long[] distance;
    static boolean minus=false;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        distance=new long[n+1];
        distance[1]=0;
        for(int i=2;i<=n;i++) distance[i]=Integer.MAX_VALUE;
        edges=new Edge[m];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            Edge temp=new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            edges[i]=(temp);
        }
        Bellman();

        if(!minus) {
            for(int i=2;i<=n;i++){
                if(distance[i]!=Integer.MAX_VALUE)
                    System.out.println(distance[i]);
                else
                    System.out.println(-1);
            }
        }else{
            System.out.println(-1);
        }

    }
    public static void Bellman(){
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                Edge now=edges[j];
                if(distance[now.s]!=Integer.MAX_VALUE &&
                    distance[now.e]>distance[now.s]+now.w){
                    distance[now.e]=distance[now.s]+now.w;
                }
            }
        }
        for(int i=0;i<m;i++){
            Edge now2=edges[i];
            if(distance[now2.s]!=Integer.MAX_VALUE &&
                    distance[now2.e]>distance[now2.s]+now2.w){
                minus=true;
            }
        }
    }
}
