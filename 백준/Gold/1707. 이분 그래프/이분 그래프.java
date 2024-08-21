import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static String[] set;
    static boolean result=true;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int k=Integer.parseInt(st.nextToken());
        for(int q=0;q<k;q++){
            st=new StringTokenizer(bf.readLine());
            int v=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            //init
            visited=new boolean[v+1];
            set=new String[v+1];
            result=true;
            graph=new ArrayList[v+1];
            for(int i=0;i<=v;i++){
                graph[i]=new ArrayList<>();
            }
            //graph 만들기
            for(int i=1;i<=e;i++){
                st=new StringTokenizer(bf.readLine());
                int S=Integer.parseInt(st.nextToken());
                int E=Integer.parseInt(st.nextToken());

                graph[S].add(E);
                graph[E].add(S);
            }

            for(int j=1;j<=v;j++){
                if(!visited[j]){
                    set[j]="A";
                    DFS(j);
                }
            }
            if(result){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    private static void DFS(int node){
        visited[node]=true;

        for(int next : graph[node]){
//            System.out.println("node = " + node+" next = " + next);
            if(!visited[next]){
//                System.out.println("set[node] = "+set[node]+" set[next] = " + set[next]);
                set[next]=set[node].equals("A") ? "B" : "A";
                DFS(next);
            }else{
                if(set[next].equals(set[node])){
                    result=false;
                }
            }
        }
    }
}